package com.aniss.postservice.clients;


import com.aniss.UserEntityRequest;
import com.aniss.UserEntityResponse;
import com.aniss.UserServiceGrpc.UserServiceBlockingStub;
import com.aniss.postservice.models.User;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class UserClient implements IUserClient {

    @GrpcClient("UserService")
    private UserServiceBlockingStub userServiceBlockingStub;

    @Override
    public User getUserById(Long id) {
        UserEntityRequest userEntityRequest = UserEntityRequest.newBuilder()
                .setId(id).build();
        UserEntityResponse userEntityResponse = userServiceBlockingStub.getUserById(userEntityRequest);
        return new User().setId((long)userEntityResponse.getId())
                .setName(userEntityResponse.getName());
    }
}
