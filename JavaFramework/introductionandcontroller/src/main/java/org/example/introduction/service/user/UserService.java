package org.example.introduction.service.user;

import lombok.RequiredArgsConstructor;
import org.example.introduction.dto.request.UserRequest;
import org.example.introduction.dto.response.UserResponse;
import org.example.introduction.entity.User;
import org.example.introduction.mapper.UserMapper;
import org.example.introduction.repositories.UserRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public Page<User> getAll(int page,int size) {
        Specification<User> specification = Specification
                .where(hasAgeGreaterThan(20));
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(specification,pageable);
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
    public static Specification<User> hasAgeGreaterThan(int age) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("age"), age);
    }
}
