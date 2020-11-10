package chatroom;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import java.io.IOException;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Server {
	private static final Logger logger = Logger.getLogger(Server.class.getName());
	
	private final int port;
	private final io.grpc.Server server;
	private static List<User> onlineUsersList = new ArrayList<>();
	
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

	  /** Stop serving requests and shutdown resources. */
	  public void stop() {
	    if (server != null) {
	      server.shutdown();
	    }
	  }

	  /**
	   * Await termination on the main thread since the grpc library uses daemon threads.
	   */
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


		
		@Override
		public void sendMessage(Message message, StreamObserver<Empty> responseObserver){
			responseObserver.onNext(sendMessageToReceiver(message));
			responseObserver.onCompleted();
		}
		
		@Override
		public void checkIfUserNameIsTaken(User user, StreamObserver<UserTaken> responseObserver){
			responseObserver.onNext(isUserNameTaken(user));
			responseObserver.onCompleted();
		}

		@Override
		public void removeOnlineUser(User user, StreamObserver<Empty> responseObserver){
			onlineUsersList.remove(user);
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



		private Empty sendMessageToReceiver(Message message){
			//berichten zenden naar receivers

			return Empty.newBuilder().build();
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
			}

			return usertaken;
		}
	}
}
