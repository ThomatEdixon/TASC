package org.example.introduction.service.user;

import org.example.introduction.dto.request.UserRequest;
import org.example.introduction.dto.response.UserResponse;
import org.example.introduction.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserService {
    Page<User> getAll(int page, int size);
    User findById(int id);
    UserResponse createUser(UserRequest userRequest);
    UserResponse updateUser(int id, UserRequest userRequest);
    List<User> deleteUser(int id);
}
