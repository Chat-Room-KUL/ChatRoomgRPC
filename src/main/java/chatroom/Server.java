package chatroom;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Server {
	private static final Logger logger = Logger.getLogger(Server.class.getName());
	
	private final int port;
	private final io.grpc.Server server;
	private static List<User> onlineUsersList = new ArrayList<>();
	private static HashMap<User, StreamObserver<Message>> onlineUsersObservers = new HashMap<>();
	
	public Server(int port) throws IOException {
		this(ServerBuilder.forPort(port), port);
		onlineUsersList.add(User.newBuilder().setName("GroupChat").build());
	}
	
	public Server(ServerBuilder<?> serverBuilder, int port){
		this.port = port;
		server = serverBuilder.addService(new ChatRoomService()).build();
	}
	
	public void start() throws IOException{
		server.start();
		logger.info("Server started, listening on " + port);
	    Runtime.getRuntime().addShutdownHook(new Thread() {
	        @Override
	        public void run() {
	          // Use stderr here since the logger may has been reset by its JVM shutdown hook.
	          System.err.println("*** shutting down gRPC server since JVM is shutting down");
	          Server.this.stop();
	          System.err.println("*** server shut down");
	        }
	      });
	}

	// Stop serving requests and shutdown resources.
	public void stop() {
        if (server != null) {
          server.shutdown();
        }
      }

    // Await termination on the main thread since the grpc library uses daemon threads.
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
          server.awaitTermination();
        }
      }

	public static void main(String[] args) throws Exception{
		Server server = new Server(50050);
	    server.start();
	    server.blockUntilShutdown();
	}
	
	private static class ChatRoomService extends ChatRoomGrpc.ChatRoomImplBase {

		private User onlineUser = null;


		@Override
		public StreamObserver<Message> sendMessage(StreamObserver<Message> responseObserver) {

			addUserObeserver(onlineUser, responseObserver);

			return new StreamObserver<Message>() {
				@Override
				public void onNext(Message message) {
					System.out.println("Hier een message ontvangen in de server:" + message.getMessage());
					//This method is called when a client sends a message to the server
					switch (message.getType()) {
						case "Message":
							if (message.getReceiver().getName().equals("GroupChat")) {

								// Getting an iterator
								Iterator iterator = onlineUsersObservers.entrySet().iterator();

								while (iterator.hasNext()) {
									Map.Entry entry = (Map.Entry)iterator.next();
									StreamObserver<Message> observer = (StreamObserver<Message>) entry.getValue();
									observer.onNext(message);								}

							}else{

								User receiver = message.getReceiver();
								User sender = message.getSender();

								if(receiver.getName().equals(sender.getName())){
									StreamObserver<Message> observerReceiver = onlineUsersObservers.get(receiver);
									observerReceiver.onNext(message);
								}else{
									StreamObserver<Message> observerReceiver = onlineUsersObservers.get(receiver);
									observerReceiver.onNext(message);

									StreamObserver<Message> observerSender = onlineUsersObservers.get(sender);
									observerSender.onNext(message);
								}
							}
							break;
						case "New User":
							User sender = message.getSender();
							System.out.println("Send new user update to everyone");
							// Getting an iterator
							Iterator iterator = onlineUsersObservers.entrySet().iterator();

							while (iterator.hasNext()) {
								Map.Entry entry = (Map.Entry)iterator.next();

								if(!((User)entry.getKey()).getName().equals(sender.getName())){
									StreamObserver<Message> observer = (StreamObserver<Message>) entry.getValue();
									observer.onNext(message);
								}

							}
							break;
						case "Remove User":
							System.out.println("Removing user");
							// Getting an iterator
							Iterator iterator1 = onlineUsersObservers.entrySet().iterator();

							while (iterator1.hasNext()) {
								Map.Entry entry = (Map.Entry)iterator1.next();


									StreamObserver<Message> observer = (StreamObserver<Message>) entry.getValue();
									observer.onNext(message);

							}
							break;
					}
					}


				@Override
				public void onError(Throwable throwable) {
					logger.log(Level.SEVERE, "gRPC error", throwable);

				}

				@Override
				public void onCompleted() {
					responseObserver.onCompleted();
				}
			};
		}
		
		@Override
		public void checkIfUserNameIsTaken(User user, StreamObserver<UserTaken> responseObserver){
			responseObserver.onNext(isUserNameTaken(user));
			responseObserver.onCompleted();
		}

		@Override
		public void removeOnlineUser(User user, StreamObserver<Empty> responseObserver){
			onlineUsersList.remove(user);
			onlineUsersObservers.remove(user);
			responseObserver.onNext(Empty.newBuilder().build());
			responseObserver.onCompleted();
		}

		@Override
		public void getOnlineUsers(Empty nul, StreamObserver<User> responseObserver){
			for(int i = 0; i < onlineUsersList.size(); i++){
				responseObserver.onNext(onlineUsersList.get(i));
			}
			
			responseObserver.onCompleted();
		}



		private void addUserObeserver(User user, StreamObserver<Message> observer){
			onlineUsersObservers.putIfAbsent(user, observer);
		}

		private UserTaken isUserNameTaken(User user){
			UserTaken usertaken = UserTaken.newBuilder().setTaken(false).build();
			System.out.println("Check if username is taken");
			String userName = user.getName();
			boolean userNameTaken = false;
			int i = 0;
			while(!userNameTaken && i<onlineUsersList.size()) {

				if(onlineUsersList.get(i).getName().equals(userName)){
					userNameTaken = true;
					System.out.println("User name is taken");
					usertaken = UserTaken.newBuilder().setTaken(true).build();
				}
				i++;
			}

			if(!userNameTaken){
				onlineUsersList.add(user);
				onlineUser = user;
			}

			return usertaken;
		}
	}
}
