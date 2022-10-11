package com.example.robot.Data.Repositiories;

import com.example.robot.Data.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
