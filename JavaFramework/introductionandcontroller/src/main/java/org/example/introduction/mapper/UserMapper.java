package org.example.introduction.mapper;

import org.example.introduction.dto.request.UserRequest;
import org.example.introduction.dto.response.UserResponse;
import org.example.introduction.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequest userRequest);
    UserResponse toUserResponse(User user);
    User updateUser(@MappingTarget User user ,UserRequest userRequest);
}
