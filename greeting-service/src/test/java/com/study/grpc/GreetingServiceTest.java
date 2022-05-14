package com.study.grpc;

import com.study.grpc.service.GreetingServiceImpl;
import io.grpc.internal.testing.StreamRecorder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@SpringJUnitConfig(classes = { UnitTestConfiguration.class })
public class GreetingServiceTest {

    @Autowired
    private GreetingServiceImpl greetingService;

    @Test
    public void testSayHello() throws Exception {
        String message = "test";
        GreetingRequest request = GreetingRequest.newBuilder()
            .setMessage(message)
            .setMessageType(MessageType.INFO)
            .build();

        StreamRecorder<GreetingResponse> responseObserver = StreamRecorder.create();
        greetingService.greeting(request, responseObserver);
        if (!responseObserver.awaitCompletion(2, TimeUnit.SECONDS)) {
            Assertions.fail("awaitCompletion fail");
        }
        Assertions.assertNull(responseObserver.getError());

        List<GreetingResponse> greetingResponses = responseObserver.getValues();
        Assertions.assertFalse(greetingResponses.isEmpty());

        GreetingResponse response = greetingResponses.get(0);
        Assertions.assertEquals(response.getMessage(), message + " received from Server");
    }
}
