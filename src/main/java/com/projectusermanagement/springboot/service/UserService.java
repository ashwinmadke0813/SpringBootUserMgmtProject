package com.projectusermanagement.springboot.service;

import com.projectusermanagement.springboot.dto.UserDto;
import com.projectusermanagement.springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser( long userId);
}
