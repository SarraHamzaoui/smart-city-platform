package com.smartcity.emergencygrpc.stubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: emergency.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EmergencyServiceGrpc {

  private EmergencyServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.smartcity.emergencygrpc.EmergencyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartcity.emergencygrpc.stubs.Empty,
      com.smartcity.emergencygrpc.stubs.VehiclePosition> getStreamVehiclePositionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamVehiclePositions",
      requestType = com.smartcity.emergencygrpc.stubs.Empty.class,
      responseType = com.smartcity.emergencygrpc.stubs.VehiclePosition.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartcity.emergencygrpc.stubs.Empty,
      com.smartcity.emergencygrpc.stubs.VehiclePosition> getStreamVehiclePositionsMethod() {
    io.grpc.MethodDescriptor<com.smartcity.emergencygrpc.stubs.Empty, com.smartcity.emergencygrpc.stubs.VehiclePosition> getStreamVehiclePositionsMethod;
    if ((getStreamVehiclePositionsMethod = EmergencyServiceGrpc.getStreamVehiclePositionsMethod) == null) {
      synchronized (EmergencyServiceGrpc.class) {
        if ((getStreamVehiclePositionsMethod = EmergencyServiceGrpc.getStreamVehiclePositionsMethod) == null) {
          EmergencyServiceGrpc.getStreamVehiclePositionsMethod = getStreamVehiclePositionsMethod =
              io.grpc.MethodDescriptor.<com.smartcity.emergencygrpc.stubs.Empty, com.smartcity.emergencygrpc.stubs.VehiclePosition>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamVehiclePositions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.emergencygrpc.stubs.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.emergencygrpc.stubs.VehiclePosition.getDefaultInstance()))
              .setSchemaDescriptor(new EmergencyServiceMethodDescriptorSupplier("StreamVehiclePositions"))
              .build();
        }
      }
    }
    return getStreamVehiclePositionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartcity.emergencygrpc.stubs.EmergencyAlert,
      com.smartcity.emergencygrpc.stubs.Ack> getSendEmergencyAlertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendEmergencyAlert",
      requestType = com.smartcity.emergencygrpc.stubs.EmergencyAlert.class,
      responseType = com.smartcity.emergencygrpc.stubs.Ack.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartcity.emergencygrpc.stubs.EmergencyAlert,
      com.smartcity.emergencygrpc.stubs.Ack> getSendEmergencyAlertMethod() {
    io.grpc.MethodDescriptor<com.smartcity.emergencygrpc.stubs.EmergencyAlert, com.smartcity.emergencygrpc.stubs.Ack> getSendEmergencyAlertMethod;
    if ((getSendEmergencyAlertMethod = EmergencyServiceGrpc.getSendEmergencyAlertMethod) == null) {
      synchronized (EmergencyServiceGrpc.class) {
        if ((getSendEmergencyAlertMethod = EmergencyServiceGrpc.getSendEmergencyAlertMethod) == null) {
          EmergencyServiceGrpc.getSendEmergencyAlertMethod = getSendEmergencyAlertMethod =
              io.grpc.MethodDescriptor.<com.smartcity.emergencygrpc.stubs.EmergencyAlert, com.smartcity.emergencygrpc.stubs.Ack>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendEmergencyAlert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.emergencygrpc.stubs.EmergencyAlert.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.emergencygrpc.stubs.Ack.getDefaultInstance()))
              .setSchemaDescriptor(new EmergencyServiceMethodDescriptorSupplier("SendEmergencyAlert"))
              .build();
        }
      }
    }
    return getSendEmergencyAlertMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EmergencyServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EmergencyServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EmergencyServiceStub>() {
        @java.lang.Override
        public EmergencyServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EmergencyServiceStub(channel, callOptions);
        }
      };
    return EmergencyServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EmergencyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EmergencyServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EmergencyServiceBlockingStub>() {
        @java.lang.Override
        public EmergencyServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EmergencyServiceBlockingStub(channel, callOptions);
        }
      };
    return EmergencyServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EmergencyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EmergencyServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EmergencyServiceFutureStub>() {
        @java.lang.Override
        public EmergencyServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EmergencyServiceFutureStub(channel, callOptions);
        }
      };
    return EmergencyServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void streamVehiclePositions(com.smartcity.emergencygrpc.stubs.Empty request,
        io.grpc.stub.StreamObserver<com.smartcity.emergencygrpc.stubs.VehiclePosition> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamVehiclePositionsMethod(), responseObserver);
    }

    /**
     */
    default void sendEmergencyAlert(com.smartcity.emergencygrpc.stubs.EmergencyAlert request,
        io.grpc.stub.StreamObserver<com.smartcity.emergencygrpc.stubs.Ack> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendEmergencyAlertMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service EmergencyService.
   */
  public static abstract class EmergencyServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return EmergencyServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service EmergencyService.
   */
  public static final class EmergencyServiceStub
      extends io.grpc.stub.AbstractAsyncStub<EmergencyServiceStub> {
    private EmergencyServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmergencyServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EmergencyServiceStub(channel, callOptions);
    }

    /**
     */
    public void streamVehiclePositions(com.smartcity.emergencygrpc.stubs.Empty request,
        io.grpc.stub.StreamObserver<com.smartcity.emergencygrpc.stubs.VehiclePosition> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamVehiclePositionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendEmergencyAlert(com.smartcity.emergencygrpc.stubs.EmergencyAlert request,
        io.grpc.stub.StreamObserver<com.smartcity.emergencygrpc.stubs.Ack> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendEmergencyAlertMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service EmergencyService.
   */
  public static final class EmergencyServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EmergencyServiceBlockingStub> {
    private EmergencyServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmergencyServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EmergencyServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.smartcity.emergencygrpc.stubs.VehiclePosition> streamVehiclePositions(
        com.smartcity.emergencygrpc.stubs.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamVehiclePositionsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.smartcity.emergencygrpc.stubs.Ack sendEmergencyAlert(com.smartcity.emergencygrpc.stubs.EmergencyAlert request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendEmergencyAlertMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service EmergencyService.
   */
  public static final class EmergencyServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<EmergencyServiceFutureStub> {
    private EmergencyServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmergencyServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EmergencyServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartcity.emergencygrpc.stubs.Ack> sendEmergencyAlert(
        com.smartcity.emergencygrpc.stubs.EmergencyAlert request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendEmergencyAlertMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STREAM_VEHICLE_POSITIONS = 0;
  private static final int METHODID_SEND_EMERGENCY_ALERT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_VEHICLE_POSITIONS:
          serviceImpl.streamVehiclePositions((com.smartcity.emergencygrpc.stubs.Empty) request,
              (io.grpc.stub.StreamObserver<com.smartcity.emergencygrpc.stubs.VehiclePosition>) responseObserver);
          break;
        case METHODID_SEND_EMERGENCY_ALERT:
          serviceImpl.sendEmergencyAlert((com.smartcity.emergencygrpc.stubs.EmergencyAlert) request,
              (io.grpc.stub.StreamObserver<com.smartcity.emergencygrpc.stubs.Ack>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getStreamVehiclePositionsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.smartcity.emergencygrpc.stubs.Empty,
              com.smartcity.emergencygrpc.stubs.VehiclePosition>(
                service, METHODID_STREAM_VEHICLE_POSITIONS)))
        .addMethod(
          getSendEmergencyAlertMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.smartcity.emergencygrpc.stubs.EmergencyAlert,
              com.smartcity.emergencygrpc.stubs.Ack>(
                service, METHODID_SEND_EMERGENCY_ALERT)))
        .build();
  }

  private static abstract class EmergencyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EmergencyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartcity.emergencygrpc.stubs.Emergency.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EmergencyService");
    }
  }

  private static final class EmergencyServiceFileDescriptorSupplier
      extends EmergencyServiceBaseDescriptorSupplier {
    EmergencyServiceFileDescriptorSupplier() {}
  }

  private static final class EmergencyServiceMethodDescriptorSupplier
      extends EmergencyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EmergencyServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EmergencyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EmergencyServiceFileDescriptorSupplier())
              .addMethod(getStreamVehiclePositionsMethod())
              .addMethod(getSendEmergencyAlertMethod())
              .build();
        }
      }
    }
    return result;
  }
}
