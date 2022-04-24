package com.xaxage.shoppingcart.service;

import com.xaxage.shoppingcart.dto.ResponseDto;
import com.xaxage.shoppingcart.dto.authentication.SignInDto;
import com.xaxage.shoppingcart.dto.authentication.SignInResponseDto;
import com.xaxage.shoppingcart.dto.authentication.SignUpDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseDto signUp(SignUpDto signUpDto);

    SignInResponseDto signIn(SignInDto signInDto);
}
