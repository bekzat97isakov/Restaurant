package peaksoft.service;

import peaksoft.dto.request.ApplicationRequest;
import peaksoft.dto.request.UserInfoRequest;
import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.EmployeeResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserInfoResponse;
import peaksoft.dto.response.UserResponse;
import peaksoft.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    SimpleResponse saveUser(UserRequest userRequest);

    UserResponse getByUserId(Long id);

    Set<UserResponse> getAllUsers();

    Set<UserResponse> getAllUsers(Long restaurantId);

    SimpleResponse updateUser(Long id, UserRequest userRequest);

    SimpleResponse deleteUser(Long id);

    SimpleResponse application(UserRequest userRequest);

    UserInfoResponse authenticate(UserInfoRequest userInfoRequest);

    SimpleResponse applications(ApplicationRequest applicationRequest);

    Set<EmployeeResponse> getAllApplications();
}
