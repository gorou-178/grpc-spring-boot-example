# gRPC SpringBoot Example
gRPC sample application built with SpringBoot.

## Project Structure
- greeting-parent
  - greeting-common
    - Protocol Buffer Project
  - greeting-service
    - gRPC Service

## Test Example
use grpcurl command.

```shell
grpcurl --plaintext -d '{"message": "test", "messageType": "INFO"}' localhost:9090 com.study.grpc.GreetingService/greeting
```

## Reference
- [gRPC with Spring Boot Example | Protobuf Stub & Skeleton | Tech Primers - YouTube](https://youtu.be/2CWYorTWyGs)
