package chatroom;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The chatroom service definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.12.0)",
    comments = "Source: chatroom.proto")
public final class ChatRoomGrpc {

  private ChatRoomGrpc() {}

  public static final String SERVICE_NAME = "tutorial.ChatRoom";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSendMessageMethod()} instead. 
  public static final io.grpc.MethodDescriptor<chatroom.Message,
      chatroom.Message> METHOD_SEND_MESSAGE = getSendMessageMethodHelper();

  private static volatile io.grpc.MethodDescriptor<chatroom.Message,
      chatroom.Message> getSendMessageMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<chatroom.Message,
      chatroom.Message> getSendMessageMethod() {
    return getSendMessageMethodHelper();
  }

  private static io.grpc.MethodDescriptor<chatroom.Message,
      chatroom.Message> getSendMessageMethodHelper() {
    io.grpc.MethodDescriptor<chatroom.Message, chatroom.Message> getSendMessageMethod;
    if ((getSendMessageMethod = ChatRoomGrpc.getSendMessageMethod) == null) {
      synchronized (ChatRoomGrpc.class) {
        if ((getSendMessageMethod = ChatRoomGrpc.getSendMessageMethod) == null) {
          ChatRoomGrpc.getSendMessageMethod = getSendMessageMethod = 
              io.grpc.MethodDescriptor.<chatroom.Message, chatroom.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "tutorial.ChatRoom", "sendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chatroom.Message.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chatroom.Message.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatRoomMethodDescriptorSupplier("sendMessage"))
                  .build();
          }
        }
     }
     return getSendMessageMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCheckIfUserNameIsTakenMethod()} instead. 
  public static final io.grpc.MethodDescriptor<chatroom.User,
      chatroom.UserTaken> METHOD_CHECK_IF_USER_NAME_IS_TAKEN = getCheckIfUserNameIsTakenMethodHelper();

  private static volatile io.grpc.MethodDescriptor<chatroom.User,
      chatroom.UserTaken> getCheckIfUserNameIsTakenMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<chatroom.User,
      chatroom.UserTaken> getCheckIfUserNameIsTakenMethod() {
    return getCheckIfUserNameIsTakenMethodHelper();
  }

  private static io.grpc.MethodDescriptor<chatroom.User,
      chatroom.UserTaken> getCheckIfUserNameIsTakenMethodHelper() {
    io.grpc.MethodDescriptor<chatroom.User, chatroom.UserTaken> getCheckIfUserNameIsTakenMethod;
    if ((getCheckIfUserNameIsTakenMethod = ChatRoomGrpc.getCheckIfUserNameIsTakenMethod) == null) {
      synchronized (ChatRoomGrpc.class) {
        if ((getCheckIfUserNameIsTakenMethod = ChatRoomGrpc.getCheckIfUserNameIsTakenMethod) == null) {
          ChatRoomGrpc.getCheckIfUserNameIsTakenMethod = getCheckIfUserNameIsTakenMethod = 
              io.grpc.MethodDescriptor.<chatroom.User, chatroom.UserTaken>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "tutorial.ChatRoom", "checkIfUserNameIsTaken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chatroom.User.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chatroom.UserTaken.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatRoomMethodDescriptorSupplier("checkIfUserNameIsTaken"))
                  .build();
          }
        }
     }
     return getCheckIfUserNameIsTakenMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetOnlineUsersMethod()} instead. 
  public static final io.grpc.MethodDescriptor<chatroom.Empty,
      chatroom.User> METHOD_GET_ONLINE_USERS = getGetOnlineUsersMethodHelper();

  private static volatile io.grpc.MethodDescriptor<chatroom.Empty,
      chatroom.User> getGetOnlineUsersMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<chatroom.Empty,
      chatroom.User> getGetOnlineUsersMethod() {
    return getGetOnlineUsersMethodHelper();
  }

  private static io.grpc.MethodDescriptor<chatroom.Empty,
      chatroom.User> getGetOnlineUsersMethodHelper() {
    io.grpc.MethodDescriptor<chatroom.Empty, chatroom.User> getGetOnlineUsersMethod;
    if ((getGetOnlineUsersMethod = ChatRoomGrpc.getGetOnlineUsersMethod) == null) {
      synchronized (ChatRoomGrpc.class) {
        if ((getGetOnlineUsersMethod = ChatRoomGrpc.getGetOnlineUsersMethod) == null) {
          ChatRoomGrpc.getGetOnlineUsersMethod = getGetOnlineUsersMethod = 
              io.grpc.MethodDescriptor.<chatroom.Empty, chatroom.User>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "tutorial.ChatRoom", "getOnlineUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chatroom.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chatroom.User.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatRoomMethodDescriptorSupplier("getOnlineUsers"))
                  .build();
          }
        }
     }
     return getGetOnlineUsersMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRemoveOnlineUserMethod()} instead. 
  public static final io.grpc.MethodDescriptor<chatroom.User,
      chatroom.Empty> METHOD_REMOVE_ONLINE_USER = getRemoveOnlineUserMethodHelper();

  private static volatile io.grpc.MethodDescriptor<chatroom.User,
      chatroom.Empty> getRemoveOnlineUserMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<chatroom.User,
      chatroom.Empty> getRemoveOnlineUserMethod() {
    return getRemoveOnlineUserMethodHelper();
  }

  private static io.grpc.MethodDescriptor<chatroom.User,
      chatroom.Empty> getRemoveOnlineUserMethodHelper() {
    io.grpc.MethodDescriptor<chatroom.User, chatroom.Empty> getRemoveOnlineUserMethod;
    if ((getRemoveOnlineUserMethod = ChatRoomGrpc.getRemoveOnlineUserMethod) == null) {
      synchronized (ChatRoomGrpc.class) {
        if ((getRemoveOnlineUserMethod = ChatRoomGrpc.getRemoveOnlineUserMethod) == null) {
          ChatRoomGrpc.getRemoveOnlineUserMethod = getRemoveOnlineUserMethod = 
              io.grpc.MethodDescriptor.<chatroom.User, chatroom.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "tutorial.ChatRoom", "removeOnlineUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chatroom.User.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  chatroom.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatRoomMethodDescriptorSupplier("removeOnlineUser"))
                  .build();
          }
        }
     }
     return getRemoveOnlineUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatRoomStub newStub(io.grpc.Channel channel) {
    return new ChatRoomStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatRoomBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChatRoomBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatRoomFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChatRoomFutureStub(channel);
  }

  /**
   * <pre>
   * The chatroom service definition
   * </pre>
   */
  public static abstract class ChatRoomImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Send a message
     * </pre>
     */
    public io.grpc.stub.StreamObserver<chatroom.Message> sendMessage(
        io.grpc.stub.StreamObserver<chatroom.Message> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendMessageMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Ask if username exists
     * </pre>
     */
    public void checkIfUserNameIsTaken(chatroom.User request,
        io.grpc.stub.StreamObserver<chatroom.UserTaken> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckIfUserNameIsTakenMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Get online users
     * </pre>
     */
    public void getOnlineUsers(chatroom.Empty request,
        io.grpc.stub.StreamObserver<chatroom.User> responseObserver) {
      asyncUnimplementedUnaryCall(getGetOnlineUsersMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * User Going Offline
     * </pre>
     */
    public void removeOnlineUser(chatroom.User request,
        io.grpc.stub.StreamObserver<chatroom.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveOnlineUserMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMessageMethodHelper(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                chatroom.Message,
                chatroom.Message>(
                  this, METHODID_SEND_MESSAGE)))
          .addMethod(
            getCheckIfUserNameIsTakenMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                chatroom.User,
                chatroom.UserTaken>(
                  this, METHODID_CHECK_IF_USER_NAME_IS_TAKEN)))
          .addMethod(
            getGetOnlineUsersMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                chatroom.Empty,
                chatroom.User>(
                  this, METHODID_GET_ONLINE_USERS)))
          .addMethod(
            getRemoveOnlineUserMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                chatroom.User,
                chatroom.Empty>(
                  this, METHODID_REMOVE_ONLINE_USER)))
          .build();
    }
  }

  /**
   * <pre>
   * The chatroom service definition
   * </pre>
   */
  public static final class ChatRoomStub extends io.grpc.stub.AbstractStub<ChatRoomStub> {
    private ChatRoomStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatRoomStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatRoomStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatRoomStub(channel, callOptions);
    }

    /**
     * <pre>
     * Send a message
     * </pre>
     */
    public io.grpc.stub.StreamObserver<chatroom.Message> sendMessage(
        io.grpc.stub.StreamObserver<chatroom.Message> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSendMessageMethodHelper(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Ask if username exists
     * </pre>
     */
    public void checkIfUserNameIsTaken(chatroom.User request,
        io.grpc.stub.StreamObserver<chatroom.UserTaken> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckIfUserNameIsTakenMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get online users
     * </pre>
     */
    public void getOnlineUsers(chatroom.Empty request,
        io.grpc.stub.StreamObserver<chatroom.User> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetOnlineUsersMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * User Going Offline
     * </pre>
     */
    public void removeOnlineUser(chatroom.User request,
        io.grpc.stub.StreamObserver<chatroom.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveOnlineUserMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The chatroom service definition
   * </pre>
   */
  public static final class ChatRoomBlockingStub extends io.grpc.stub.AbstractStub<ChatRoomBlockingStub> {
    private ChatRoomBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatRoomBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatRoomBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatRoomBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Ask if username exists
     * </pre>
     */
    public chatroom.UserTaken checkIfUserNameIsTaken(chatroom.User request) {
      return blockingUnaryCall(
          getChannel(), getCheckIfUserNameIsTakenMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get online users
     * </pre>
     */
    public java.util.Iterator<chatroom.User> getOnlineUsers(
        chatroom.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getGetOnlineUsersMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * User Going Offline
     * </pre>
     */
    public chatroom.Empty removeOnlineUser(chatroom.User request) {
      return blockingUnaryCall(
          getChannel(), getRemoveOnlineUserMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The chatroom service definition
   * </pre>
   */
  public static final class ChatRoomFutureStub extends io.grpc.stub.AbstractStub<ChatRoomFutureStub> {
    private ChatRoomFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatRoomFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatRoomFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatRoomFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Ask if username exists
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<chatroom.UserTaken> checkIfUserNameIsTaken(
        chatroom.User request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckIfUserNameIsTakenMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * User Going Offline
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<chatroom.Empty> removeOnlineUser(
        chatroom.User request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveOnlineUserMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_IF_USER_NAME_IS_TAKEN = 0;
  private static final int METHODID_GET_ONLINE_USERS = 1;
  private static final int METHODID_REMOVE_ONLINE_USER = 2;
  private static final int METHODID_SEND_MESSAGE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChatRoomImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChatRoomImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_IF_USER_NAME_IS_TAKEN:
          serviceImpl.checkIfUserNameIsTaken((chatroom.User) request,
              (io.grpc.stub.StreamObserver<chatroom.UserTaken>) responseObserver);
          break;
        case METHODID_GET_ONLINE_USERS:
          serviceImpl.getOnlineUsers((chatroom.Empty) request,
              (io.grpc.stub.StreamObserver<chatroom.User>) responseObserver);
          break;
        case METHODID_REMOVE_ONLINE_USER:
          serviceImpl.removeOnlineUser((chatroom.User) request,
              (io.grpc.stub.StreamObserver<chatroom.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MESSAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendMessage(
              (io.grpc.stub.StreamObserver<chatroom.Message>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChatRoomBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatRoomBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return chatroom.ChatRoomProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChatRoom");
    }
  }

  private static final class ChatRoomFileDescriptorSupplier
      extends ChatRoomBaseDescriptorSupplier {
    ChatRoomFileDescriptorSupplier() {}
  }

  private static final class ChatRoomMethodDescriptorSupplier
      extends ChatRoomBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChatRoomMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChatRoomGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChatRoomFileDescriptorSupplier())
              .addMethod(getSendMessageMethodHelper())
              .addMethod(getCheckIfUserNameIsTakenMethodHelper())
              .addMethod(getGetOnlineUsersMethodHelper())
              .addMethod(getRemoveOnlineUserMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
