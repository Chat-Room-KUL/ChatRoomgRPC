package be.msec.labgrpc;

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
 * De calculator service definitie
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.12.0)",
    comments = "Source: calculator.proto")
public final class CalculatorGrpc {

  private CalculatorGrpc() {}

  public static final String SERVICE_NAME = "tutorial.Calculator";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCalculateSumMethod()} instead. 
  public static final io.grpc.MethodDescriptor<be.msec.labgrpc.Sum,
      be.msec.labgrpc.CalculatorReply> METHOD_CALCULATE_SUM = getCalculateSumMethodHelper();

  private static volatile io.grpc.MethodDescriptor<be.msec.labgrpc.Sum,
      be.msec.labgrpc.CalculatorReply> getCalculateSumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<be.msec.labgrpc.Sum,
      be.msec.labgrpc.CalculatorReply> getCalculateSumMethod() {
    return getCalculateSumMethodHelper();
  }

  private static io.grpc.MethodDescriptor<be.msec.labgrpc.Sum,
      be.msec.labgrpc.CalculatorReply> getCalculateSumMethodHelper() {
    io.grpc.MethodDescriptor<be.msec.labgrpc.Sum, be.msec.labgrpc.CalculatorReply> getCalculateSumMethod;
    if ((getCalculateSumMethod = CalculatorGrpc.getCalculateSumMethod) == null) {
      synchronized (CalculatorGrpc.class) {
        if ((getCalculateSumMethod = CalculatorGrpc.getCalculateSumMethod) == null) {
          CalculatorGrpc.getCalculateSumMethod = getCalculateSumMethod = 
              io.grpc.MethodDescriptor.<be.msec.labgrpc.Sum, be.msec.labgrpc.CalculatorReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "tutorial.Calculator", "calculateSum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.msec.labgrpc.Sum.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.msec.labgrpc.CalculatorReply.getDefaultInstance()))
                  .setSchemaDescriptor(new CalculatorMethodDescriptorSupplier("calculateSum"))
                  .build();
          }
        }
     }
     return getCalculateSumMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStreamingSumMethod()} instead. 
  public static final io.grpc.MethodDescriptor<be.msec.labgrpc.Sum,
      be.msec.labgrpc.CalculatorReply> METHOD_STREAMING_SUM = getStreamingSumMethodHelper();

  private static volatile io.grpc.MethodDescriptor<be.msec.labgrpc.Sum,
      be.msec.labgrpc.CalculatorReply> getStreamingSumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<be.msec.labgrpc.Sum,
      be.msec.labgrpc.CalculatorReply> getStreamingSumMethod() {
    return getStreamingSumMethodHelper();
  }

  private static io.grpc.MethodDescriptor<be.msec.labgrpc.Sum,
      be.msec.labgrpc.CalculatorReply> getStreamingSumMethodHelper() {
    io.grpc.MethodDescriptor<be.msec.labgrpc.Sum, be.msec.labgrpc.CalculatorReply> getStreamingSumMethod;
    if ((getStreamingSumMethod = CalculatorGrpc.getStreamingSumMethod) == null) {
      synchronized (CalculatorGrpc.class) {
        if ((getStreamingSumMethod = CalculatorGrpc.getStreamingSumMethod) == null) {
          CalculatorGrpc.getStreamingSumMethod = getStreamingSumMethod = 
              io.grpc.MethodDescriptor.<be.msec.labgrpc.Sum, be.msec.labgrpc.CalculatorReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "tutorial.Calculator", "streamingSum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.msec.labgrpc.Sum.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.msec.labgrpc.CalculatorReply.getDefaultInstance()))
                  .setSchemaDescriptor(new CalculatorMethodDescriptorSupplier("streamingSum"))
                  .build();
          }
        }
     }
     return getStreamingSumMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCalculatorHistoryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<be.msec.labgrpc.Empty,
      be.msec.labgrpc.Calculation> METHOD_CALCULATOR_HISTORY = getCalculatorHistoryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<be.msec.labgrpc.Empty,
      be.msec.labgrpc.Calculation> getCalculatorHistoryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<be.msec.labgrpc.Empty,
      be.msec.labgrpc.Calculation> getCalculatorHistoryMethod() {
    return getCalculatorHistoryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<be.msec.labgrpc.Empty,
      be.msec.labgrpc.Calculation> getCalculatorHistoryMethodHelper() {
    io.grpc.MethodDescriptor<be.msec.labgrpc.Empty, be.msec.labgrpc.Calculation> getCalculatorHistoryMethod;
    if ((getCalculatorHistoryMethod = CalculatorGrpc.getCalculatorHistoryMethod) == null) {
      synchronized (CalculatorGrpc.class) {
        if ((getCalculatorHistoryMethod = CalculatorGrpc.getCalculatorHistoryMethod) == null) {
          CalculatorGrpc.getCalculatorHistoryMethod = getCalculatorHistoryMethod = 
              io.grpc.MethodDescriptor.<be.msec.labgrpc.Empty, be.msec.labgrpc.Calculation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "tutorial.Calculator", "calculatorHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.msec.labgrpc.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.msec.labgrpc.Calculation.getDefaultInstance()))
                  .setSchemaDescriptor(new CalculatorMethodDescriptorSupplier("calculatorHistory"))
                  .build();
          }
        }
     }
     return getCalculatorHistoryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CalculatorStub newStub(io.grpc.Channel channel) {
    return new CalculatorStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CalculatorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CalculatorBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CalculatorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CalculatorFutureStub(channel);
  }

  /**
   * <pre>
   * De calculator service definitie
   * </pre>
   */
  public static abstract class CalculatorImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Bereken een som
     * </pre>
     */
    public void calculateSum(be.msec.labgrpc.Sum request,
        io.grpc.stub.StreamObserver<be.msec.labgrpc.CalculatorReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCalculateSumMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Doe een som met onbepaalde input
     * </pre>
     */
    public io.grpc.stub.StreamObserver<be.msec.labgrpc.Sum> streamingSum(
        io.grpc.stub.StreamObserver<be.msec.labgrpc.CalculatorReply> responseObserver) {
      return asyncUnimplementedStreamingCall(getStreamingSumMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Vraag de uitgevoerde berekeningen op
     * </pre>
     */
    public void calculatorHistory(be.msec.labgrpc.Empty request,
        io.grpc.stub.StreamObserver<be.msec.labgrpc.Calculation> responseObserver) {
      asyncUnimplementedUnaryCall(getCalculatorHistoryMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCalculateSumMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                be.msec.labgrpc.Sum,
                be.msec.labgrpc.CalculatorReply>(
                  this, METHODID_CALCULATE_SUM)))
          .addMethod(
            getStreamingSumMethodHelper(),
            asyncClientStreamingCall(
              new MethodHandlers<
                be.msec.labgrpc.Sum,
                be.msec.labgrpc.CalculatorReply>(
                  this, METHODID_STREAMING_SUM)))
          .addMethod(
            getCalculatorHistoryMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                be.msec.labgrpc.Empty,
                be.msec.labgrpc.Calculation>(
                  this, METHODID_CALCULATOR_HISTORY)))
          .build();
    }
  }

  /**
   * <pre>
   * De calculator service definitie
   * </pre>
   */
  public static final class CalculatorStub extends io.grpc.stub.AbstractStub<CalculatorStub> {
    private CalculatorStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorStub(channel, callOptions);
    }

    /**
     * <pre>
     * Bereken een som
     * </pre>
     */
    public void calculateSum(be.msec.labgrpc.Sum request,
        io.grpc.stub.StreamObserver<be.msec.labgrpc.CalculatorReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCalculateSumMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Doe een som met onbepaalde input
     * </pre>
     */
    public io.grpc.stub.StreamObserver<be.msec.labgrpc.Sum> streamingSum(
        io.grpc.stub.StreamObserver<be.msec.labgrpc.CalculatorReply> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getStreamingSumMethodHelper(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Vraag de uitgevoerde berekeningen op
     * </pre>
     */
    public void calculatorHistory(be.msec.labgrpc.Empty request,
        io.grpc.stub.StreamObserver<be.msec.labgrpc.Calculation> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getCalculatorHistoryMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * De calculator service definitie
   * </pre>
   */
  public static final class CalculatorBlockingStub extends io.grpc.stub.AbstractStub<CalculatorBlockingStub> {
    private CalculatorBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Bereken een som
     * </pre>
     */
    public be.msec.labgrpc.CalculatorReply calculateSum(be.msec.labgrpc.Sum request) {
      return blockingUnaryCall(
          getChannel(), getCalculateSumMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Vraag de uitgevoerde berekeningen op
     * </pre>
     */
    public java.util.Iterator<be.msec.labgrpc.Calculation> calculatorHistory(
        be.msec.labgrpc.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getCalculatorHistoryMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * De calculator service definitie
   * </pre>
   */
  public static final class CalculatorFutureStub extends io.grpc.stub.AbstractStub<CalculatorFutureStub> {
    private CalculatorFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Bereken een som
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<be.msec.labgrpc.CalculatorReply> calculateSum(
        be.msec.labgrpc.Sum request) {
      return futureUnaryCall(
          getChannel().newCall(getCalculateSumMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CALCULATE_SUM = 0;
  private static final int METHODID_CALCULATOR_HISTORY = 1;
  private static final int METHODID_STREAMING_SUM = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CalculatorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CalculatorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALCULATE_SUM:
          serviceImpl.calculateSum((be.msec.labgrpc.Sum) request,
              (io.grpc.stub.StreamObserver<be.msec.labgrpc.CalculatorReply>) responseObserver);
          break;
        case METHODID_CALCULATOR_HISTORY:
          serviceImpl.calculatorHistory((be.msec.labgrpc.Empty) request,
              (io.grpc.stub.StreamObserver<be.msec.labgrpc.Calculation>) responseObserver);
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
        case METHODID_STREAMING_SUM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamingSum(
              (io.grpc.stub.StreamObserver<be.msec.labgrpc.CalculatorReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CalculatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CalculatorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return be.msec.labgrpc.TutorialProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Calculator");
    }
  }

  private static final class CalculatorFileDescriptorSupplier
      extends CalculatorBaseDescriptorSupplier {
    CalculatorFileDescriptorSupplier() {}
  }

  private static final class CalculatorMethodDescriptorSupplier
      extends CalculatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CalculatorMethodDescriptorSupplier(String methodName) {
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
      synchronized (CalculatorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CalculatorFileDescriptorSupplier())
              .addMethod(getCalculateSumMethodHelper())
              .addMethod(getStreamingSumMethodHelper())
              .addMethod(getCalculatorHistoryMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
