package chatroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import chatroom.ChatRoomGrpc.ChatRoomBlockingStub;
import chatroom.ChatRoomGrpc.ChatRoomStub;

public class Client extends Application{
	private static final Logger logger = Logger.getLogger(Client.class.getName());
	
	private final ManagedChannel channel;
	private final ChatRoomBlockingStub blockingStub;
	private final ChatRoomStub asyncStub;
	private StreamObserver<Message> streamObserverToServer;
	private ClientController controller = null;
	private String userName;

	public Client(){
		channel = null;
		blockingStub = null;
		asyncStub = null;
	}

	public Client(String host, int port){
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext(true));
	}
	
	public Client(ManagedChannelBuilder<?> channelBuilder) {
		channel = channelBuilder.build();
		blockingStub = ChatRoomGrpc.newBlockingStub(channel);
		asyncStub = ChatRoomGrpc.newStub(channel);
	}

	public void setController(ClientController controller){
		this.controller = controller;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
	
	public void initializeChat(){

		streamObserverToServer = asyncStub.sendMessage(
				new StreamObserver<Message>() {
					@Override
					public void onNext(Message message) {
						//When a message from the server arrives this method is called
						System.out.println("Bericht ontvangen");
						switch (message.getType()) {
							case "Message":
								if (message.getReceiver().getName().equals("GroupChat")) {
									Platform.runLater(new Runnable () {
										@Override
										public void run() {
											controller.addMessageToChatRoom("GroupChat",message.getSender().getName()+": "+message.getMessage());
										}
									});

								}else{
									System.out.println("Bericht ontvangen voor private chat");
									Platform.runLater(new Runnable () {
										@Override
										public void run() {

											User receiver = message.getReceiver();
											User sender = message.getSender();

											if(receiver.getName().equals(sender.getName())){
												controller.addMessageToChatRoom(message.getReceiver().getName(), message.getSender().getName() + ": " + message.getMessage());
											}else {
												if (message.getSender().getName().equals(userName)) {
													controller.addMessageToChatRoom(message.getReceiver().getName(), message.getSender().getName() + ": " + message.getMessage());
												} else{
													controller.addMessageToChatRoom(message.getSender().getName(), message.getSender().getName() + ": " + message.getMessage());
												}

											}
										}
									});
								}
								break;
							case "New User":
								Platform.runLater(new Runnable () {
									@Override
									public void run() {
										controller.addOnlineUser(message.getSender().getName());
									}
								});
								break;
							case "Remove User":
								Platform.runLater(new Runnable () {
									@Override
									public void run() {
										controller.removeOnlineUser(message.getSender().getName());
									}
								});
								break;
						}

					}

					@Override
					public void onError(Throwable throwable) {
						logger.log(Level.SEVERE, "gRPC error", throwable);
						try {
							shutdown();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					@Override
					public void onCompleted() {
						logger.severe("The server closed the connection, shutting down...");
						try {
							shutdown();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});
	}
	
	public boolean checkIfUserNameIsTaken(String userName){

		User request = User.newBuilder().setName(userName).build();
		UserTaken reply;
		try{
			System.out.println("Hier");
			System.out.println(blockingStub);
			reply = blockingStub.checkIfUserNameIsTaken(request);
		} catch (StatusRuntimeException e) {
			logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
			return true;
		}

		if(reply.getTaken()){
			return true;
		} else {
			return false;
		}
	}
	
	public void removeOnlineUser(String userName){

		User request = User.newBuilder().setName(userName).build();
		Empty reply;
		try{
			reply = blockingStub.removeOnlineUser(request);
		} catch (StatusRuntimeException e) {
			logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
			return;
		}

	}

	public List<String> getOnlineUsers(){
		List<String> onlineUsersStringList = new ArrayList<String>();

		Iterator<User> onlineUsers = null;
		try{
			onlineUsers = blockingStub.getOnlineUsers(Empty.newBuilder().build());
		} catch (StatusRuntimeException e) {
			logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		}

		while(onlineUsers.hasNext()){
			User user = onlineUsers.next();
			onlineUsersStringList.add(user.getName());
		}

		return onlineUsersStringList;
	}


	@Override
	public void start(Stage primaryStage) throws Exception{

		//Making a connection to the server
		Client client = new Client("localhost", 50050);

		FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatRoomGUI.fxml"));
		loader.setLocation(getClass().getClassLoader().getResource("ChatRoomGUI.fxml"));
		Parent root = (Parent)loader.load();

		primaryStage.setTitle("Chat Room");
		primaryStage.setScene(new Scene(root, 600, 400));
		primaryStage.setMinWidth(600);
		primaryStage.setMinHeight(400);
		primaryStage.show();
		controller = loader.getController();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				try {
					controller.deleteMyUsername();
					client.shutdown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		controller.setClient(client);
		client.setController(controller);

		//Username creation and check
		boolean usernameChosen = false;
		String dialogHeader = "Choose your username";

		String userName = null;

		while(!usernameChosen) {
			TextInputDialog dialog = new TextInputDialog();

			// inlezen van de usernaam
			dialog.initOwner(primaryStage);
			dialog.setTitle("Welcome");
			dialog.setHeaderText(dialogHeader);
			dialog.setContentText("Username");
			dialog.setGraphic(null);

			try {
				userName = dialog.showAndWait().get();
			} catch (Exception e) {
			}

			if(userName != null && !userName.trim().equals("")){


				if(!client.checkIfUserNameIsTaken(userName)){
					usernameChosen = true;
					controller.setUsername(userName);
					primaryStage.setTitle(userName + "'s Chat Room");
				}
				else{
					dialogHeader = "Username already exist, please choose an other username!";
				}
			}
		}

		client.setUserName(userName);

		//asking the online users and receiving online users
		OnlineUsersList onlineUsersList = new OnlineUsersList();

		controller.setOnlineUsersList(onlineUsersList);

		onlineUsersList.addObserver(controller);

		controller.updateOnlineUsers();

		ChatRoom chatroom = new ChatRoom("GroupChat");
		controller.addChatRoom(chatroom);

		client.initializeChat();

		StreamObserver<Message> toServer = client.getStreamObserverToServer();
		if (toServer != null) {
			toServer.onNext(Message.newBuilder().setType("New User").setSender(User.newBuilder().setName(userName).build()).build());
		}
	}


	public static void main(String[] args) throws InterruptedException {
		launch(args);
	}

	private static void info(String msg, Object... params) {
		logger.log(Level.INFO, msg, params);
	}

	public StreamObserver<Message> getStreamObserverToServer() {
		return streamObserverToServer;
	}
}