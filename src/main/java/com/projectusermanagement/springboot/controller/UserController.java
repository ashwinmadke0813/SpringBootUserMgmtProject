package com.projectusermanagement.springboot.controller;

import com.projectusermanagement.springboot.dto.UserDto;
import com.projectusermanagement.springboot.entity.User;
import com.projectusermanagement.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    //build create user REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //build get user by id REST API
    //http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //build get all users by id REST API
    //http://localhost:8080/api/users
    @GetMapping
    public  ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    //build update user REST API
    //http://localhost:8080/api/users/1
    @PutMapping("{id}")
    public  ResponseEntity<User> updateUser( @PathVariable("id") long userId,
                                             @RequestBody User user){ // @RequestBody will convert json into user java object
        user.setId(userId);
        User updatedUser = userService.updateUser(user);
        return  new ResponseEntity<>(updatedUser,HttpStatus.OK);

    }

    //build delete user REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!",HttpStatus.OK);
    }
}
