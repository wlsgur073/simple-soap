package com.example.soap;

import com.example.user.GetUserRequest;
import com.example.user.GetUserResponse;
import com.example.user.User;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/user";

    private final UserRepository userRepository;

    public UserEndpoint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 단일 사용자 조회
     * request: getUserRequest(userId)
     * response: getUserResponse(user)
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();

        try {
            User user = userRepository.getUserById(request.getUserId());
            response.setUser(user);
        } catch (Exception e) {
            throw new RuntimeException("사용자 조회 실패: " + e.getMessage());
        }

        return response;
    }

}