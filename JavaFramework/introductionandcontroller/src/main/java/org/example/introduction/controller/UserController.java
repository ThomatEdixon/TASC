package org.example.introduction.controller;

import lombok.RequiredArgsConstructor;
import org.example.introduction.dto.request.UserRequest;
import org.example.introduction.entity.User;
import org.example.introduction.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.createUser(userRequest));
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
