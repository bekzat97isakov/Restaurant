package peaksoft.service;

import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.UserResponse;
import peaksoft.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(UserRequest userRequest);
    List<UserResponse> findAll();
    User getByIdUser(Long userId);
    User updateByIdUser(Long userId, User user);
    void deleteByIdUser(Long userId);
}
