package chatroom;

import io.grpc.stub.StreamObserver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ClientController implements Observer {

    private Client client;
    private String username;
    private OnlineUsersList onlineUsersList;
    private List<ChatRoom> chatRooms = new ArrayList<ChatRoom>();
    private String currentActiveChatRoom = "GroupChat";

    @FXML
    public Label chatBox;

    @FXML
    public Button sendMessageButton;

    @FXML
    public TextField messageInput;

    @FXML
    private ListView<String> onlineUsers;

    private ObservableList<String> items = FXCollections.observableArrayList();

    public ClientController() {
    }

    public void setOnlineUsersList(OnlineUsersList onlineUsers){
        this.onlineUsersList = onlineUsers;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public void updateOnlineUsers() throws IOException {

        List<String> onlineUsers = new ArrayList<String>();

        onlineUsers = client.getOnlineUsers();

        onlineUsersList.setOnlineUsers(onlineUsers);

    }

    @FXML
    public void update(Observable arg0, Object arg1) { // Called from the Model
        System.out.println("Update gedetecteerd");
        System.out.println(onlineUsersList.getOnlineUsers());
        onlineUsers.getItems().clear();
        onlineUsers.setItems(items);
        List<String> users = onlineUsersList.getOnlineUsers();
        for(int i=0;i<users.size();i++){
            items.add(users.get(i));
        }
    }

    public void sendMessage(ActionEvent actionEvent) {
        String message = messageInput.getText();
        if(!currentActiveChatRoom.equals(username)){
            System.out.println("Hier berivicht sturen.");
            StreamObserver<Message> toServer = client.getStreamObserverToServer();
            if (toServer != null) {
                System.out.println("Hier toServer bestaat blijkbaar");
                toServer.onNext(Message.newBuilder().setType("Message").setReceiver(User.newBuilder().setName(currentActiveChatRoom).build()).setSender(User.newBuilder().setName(username).build()).setMessage(message).build());
            }
        }
    }

    public void deleteMyUsername() throws InterruptedException {

        client.removeOnlineUser(username);
        StreamObserver<Message> toServer = client.getStreamObserverToServer();
        if (toServer != null) {
            toServer.onNext(Message.newBuilder().setType("Remove User").setSender(User.newBuilder().setName(username).build()).build());
        }
        client.shutdown();
        System.out.println(username+" is sayin bye.");

    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public void addChatRoom(ChatRoom chatroom) {
        chatRooms.add(chatroom);
    }

    public void addMessageToChatRoom(String chatName, String message) {

        //Find chat with appropriate name
        boolean chatroomFound = false;
        ChatRoom chatroom = null;
        int i=0;
        while(!chatroomFound&&chatRooms.size()!=i){
            System.out.println("Zoeken naar chatroom");
            System.out.println(chatName);
            System.out.println(chatRooms.get(i).getChatRoomName());
            System.out.println(chatRooms.get(i).getChatRoomName().equals(chatName));
            if(chatRooms.get(i).getChatRoomName().equals(chatName)){
                chatroom = chatRooms.get(i);
                chatroomFound = true;
                chatroom.addMessage(message);
                System.out.println(message);

            }
            i++;
        }

        if(!chatroomFound) {
            chatroom = new ChatRoom(chatName);
            this.addChatRoom(chatroom);
            chatroom.addMessage(message);
        }

        System.out.println(chatroom.toString());
        if(chatName.equals(currentActiveChatRoom)){
            chatBox.setText(chatroom.toString());
        }

    }

    public void removeOnlineUser(String name) {
        onlineUsersList.removeOnlineUser(name);
    }

    public void addOnlineUser(String name) {
        onlineUsersList.addOnlineUser(name);
    }

    public void createPrivateChat(MouseEvent mouseEvent) {
        String name = onlineUsers.getSelectionModel().getSelectedItem();
        System.out.println("clicked on " + onlineUsers.getSelectionModel().getSelectedItem());
        ChatRoom currentChatRoom = new ChatRoom();

        boolean chatRoomExists = false;
        int i=0;
        while(!chatRoomExists&&i!=chatRooms.size()){
            if(chatRooms.get(i).getChatRoomName().equals(name)){
                chatRoomExists = true;
                currentChatRoom = chatRooms.get(i);
            }
            i++;
        }

        if(!chatRoomExists){
            currentChatRoom = new ChatRoom(name);
            this.addChatRoom(currentChatRoom);
        }
        currentActiveChatRoom = name;
        chatBox.setText(currentChatRoom.toString());
    }
}