package com.example.robot.Manager.Security;

import com.example.robot.Data.Repositiories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;


    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {this.userRepository = userRepository; this.passwordEncoder = passwordEncoder;}

    @GetMapping
    public String registerForm() {return "registration"; }

    @PostMapping
    public String processRegistration(RegistrationForm form) {

        userRepository.save(form.toUser(passwordEncoder));
        log.info(userRepository.findAll().toString());
        return "redirect:/login";
    }
}
