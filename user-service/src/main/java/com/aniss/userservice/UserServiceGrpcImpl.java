package com.aniss.userservice;

import com.aniss.UserEntityRequest;
import com.aniss.UserEntityResponse;
import com.aniss.UserServiceGrpc;
import com.aniss.userservice.entities.User;
import com.aniss.userservice.services.UserService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@GrpcService
public class UserServiceGrpcImpl extends UserServiceGrpc.UserServiceImplBase {

    @Autowired
    private UserService userService;

    @Override
    public void getUserById(UserEntityRequest request, StreamObserver<UserEntityResponse> responseObserver) {
        Optional<User> user = userService.get((long)request.getId());
        if ( user.isPresent() )
        {
            responseObserver.onNext(UserEntityResponse.newBuilder()
                    .setName(user.get().getName())
                    .setId(user.get().getId())
                    .build());
            responseObserver.onCompleted();
        }
        else
        {
            responseObserver.onError(Status.NOT_FOUND.asException());
        }
    }
}
