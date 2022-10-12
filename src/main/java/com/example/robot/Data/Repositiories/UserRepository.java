package com.example.robot.Data.Repositiories;

import com.example.robot.Data.UserData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserData, Long> {
    UserData findByUsername(String username);
}
