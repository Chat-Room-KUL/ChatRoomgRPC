package chatroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import javafx.application.Application;
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

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
	
	public void sendMessage(String chatName, String message){
		//info("Calculating sum of {0} and {1}", a, b);
		
		//Sum request = Sum.newBuilder().setA(a).setB(b).build();
		//CalculatorReply reply;
		/*try{
			reply = blockingStub.calculateSum(request);
		} catch (StatusRuntimeException e) {
			logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
			return;
		}
		
		info("Solution of the {0} + {1} = {2}", a, b, reply.getSolution());
	*/}
	
	public boolean checkIfUserNameIsTaken(String userName){

		User request = User.newBuilder().setName(userName).build();
		UserTaken reply;
		try{
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


		//info("Streaming sum");
		//final CountDownLatch finishLatch = new CountDownLatch(1);
		/*StreamObserver<CalculatorReply> responseObserver = new StreamObserver<CalculatorReply>() {
			@Override
			public void onNext(CalculatorReply reply) {
				info("Finished streaming sum. The solution is {0}", reply.getSolution());
			}
			
			@Override
			public void onError(Throwable t){
				Status status = Status.fromThrowable(t);
				logger.log(Level.WARNING, "StreamingSum failed:{0}", status);
				finishLatch.countDown();
			}
			
			@Override
			public void onCompleted(){
				info("Finished StreamingSum");
				finishLatch.countDown();
			}
		};
		
		StreamObserver<Sum> requestObserver = asyncStub.streamingSum(responseObserver);
		try{
			int a;
			int b;
			Sum request;
			for(int i = 0; i < (operands+1)/2; i++){
				a = (int)(Math.random() * 10);
				b = (int)(Math.random() * 10);
				if(i == ((operands+1)/2-1) && (operands % 2) != 0){
					b = 0;
					info("Adding new summand {0}", a);
				} else
					info("Adding new summands {0} and {1} ", a, b);
				
				request = Sum.newBuilder().setA(a).setB(b).build();
				
				requestObserver.onNext(request);
				
				Thread.sleep(1000);
				if (finishLatch.getCount() == 0){
					// RPC completed or errored before we finished sending.
					// Sending further request won't error, but they will just be thrown away.
					return;
				}
					
			}
		} catch (RuntimeException e){
			requestObserver.onError(e);
			throw e;
		}
		
		// Mark the end of requests
		requestObserver.onCompleted();
		
		// Receiving happens asynchronously
		finishLatch.await(1, TimeUnit.MINUTES);*/
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

		FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatRoomGUI.fxml"));
		loader.setLocation(getClass().getClassLoader().getResource("ChatRoomGUI.fxml"));
		Parent root = (Parent)loader.load();

		primaryStage.setTitle("Chat Room");
		primaryStage.setScene(new Scene(root, 600, 400));
		primaryStage.setMinWidth(600);
		primaryStage.setMinHeight(400);
		primaryStage.show();
		ClientController controller = loader.getController();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				try {
					controller.deleteMyUsername();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		//Making a connection to the server
		Client client = new Client("localhost", 50050);

		controller.setClient(client);

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

		//asking the online users and receiving online users
		OnlineUsersList onlineUsersList = new OnlineUsersList();

		controller.setOnlineUsersList(onlineUsersList);

		onlineUsersList.addObserver(controller);

		controller.updateOnlineUsers();

		ChatRoom chatroom = new ChatRoom("GroupChat");
		controller.addChatRoom(chatroom);

	}


	public static void main(String[] args) throws InterruptedException {
		launch(args);
	}

	private static void info(String msg, Object... params) {
		logger.log(Level.INFO, msg, params);
	}

}