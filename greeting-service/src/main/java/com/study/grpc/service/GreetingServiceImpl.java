package com.study.grpc.service;

import com.study.grpc.GreetingRequest;
import com.study.grpc.GreetingResponse;
import com.study.grpc.GreetingServiceGrpc.GreetingServiceImplBase;
import com.study.grpc.MessageType;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingServiceImpl extends GreetingServiceImplBase {

    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String message = request.getMessage();
        MessageType messageType = request.getMessageType();
        System.out.println("Received Message:[" + messageType + "] " + message);

        String responseMessage = message + " received from Server";
        GreetingResponse response = GreetingResponse.newBuilder().setMessage(responseMessage).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
