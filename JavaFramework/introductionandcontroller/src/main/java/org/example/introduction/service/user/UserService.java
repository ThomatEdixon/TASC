package org.example.introduction.service.user;

import lombok.RequiredArgsConstructor;
import org.example.introduction.dto.request.UserRequest;
import org.example.introduction.dto.response.UserResponse;
import org.example.introduction.entity.User;
import org.example.introduction.mapper.UserMapper;
import org.example.introduction.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow();
        return user;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User newUsers = userMapper.toUser(userRequest);
        return userMapper.toUserResponse(userRepository.save(newUsers));
    }

    @Override
    public UserResponse updateUser(int id, UserRequest userRequest) {
        User userExisting = userRepository.findById(id)
                .orElseThrow();
        userMapper.updateUser(userExisting,userRequest);
        return userMapper.toUserResponse(userRepository.save(userExisting));
    }

    @Override
    public List<User> deleteUser(int id) {
        userRepository.deleteById(id);
        return userRepository.findAll();
    }
}
