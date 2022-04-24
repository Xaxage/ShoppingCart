package com.xaxage.shoppingcart.controller;

import com.xaxage.shoppingcart.dto.ResponseDto;
import com.xaxage.shoppingcart.dto.authentication.SignInDto;
import com.xaxage.shoppingcart.dto.authentication.SignInResponseDto;
import com.xaxage.shoppingcart.dto.authentication.SignUpDto;
import com.xaxage.shoppingcart.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseDto signUp(@RequestBody SignUpDto signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signIn")
    public SignInResponseDto signIn(@RequestBody SignInDto signInDto){
        return userService.signIn(signInDto);
    }


}
