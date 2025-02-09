package dev.srijit.BookMyShow.controller;

import dev.srijit.BookMyShow.dto.UserLoginRequestDTO;
import dev.srijit.BookMyShow.dto.UserSignUpRequestDTO;
import dev.srijit.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginRequestDTO requestDTO) throws Exception {
        //validate the userdata
        return ResponseEntity.ok(
                userService.login(requestDTO.getEmail(), requestDTO.getPassword())
        );
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserSignUpRequestDTO requestDTO) throws Exception {
        //validate the userdata
        return ResponseEntity.ok(
                userService.signUp(requestDTO.getName(), requestDTO.getEmail(), requestDTO.getPassword())
        );
    }
}
