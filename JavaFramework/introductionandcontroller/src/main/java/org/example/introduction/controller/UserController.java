package org.example.introduction.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.introduction.dto.request.ApiResponse;
import org.example.introduction.dto.request.UserRequest;
import org.example.introduction.dto.response.UserResponse;
import org.example.introduction.entity.User;
import org.example.introduction.service.user.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "5") int size)
    {
        Page<User> userPage = userService.getAll(page, size);
        return ResponseEntity.ok(userPage.getContent());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return ResponseEntity.ok(userService.findById(id));
    }
    @PostMapping("")
    public ApiResponse<UserResponse> create(@RequestBody @Valid UserRequest userRequest){
        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(userRequest))
                .build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.updateUser(id,userRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }

}
