package com.example.robot.Manager.Security;

import com.example.robot.Data.UserData;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    private String username;
    private String password;

    public UserData toUser(PasswordEncoder passwordEncoder) {

        return new UserData(username, passwordEncoder.encode(password));
    }
}
