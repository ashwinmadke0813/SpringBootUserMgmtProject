package com.projectusermanagement.springboot.repository;

import com.projectusermanagement.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
