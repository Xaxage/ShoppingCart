package com.xaxage.shoppingcart.service;

import com.xaxage.shoppingcart.dto.ResponseDto;
import com.xaxage.shoppingcart.dto.authentication.SignInDto;
import com.xaxage.shoppingcart.dto.authentication.SignInResponseDto;
import com.xaxage.shoppingcart.dto.authentication.SignUpDto;
import com.xaxage.shoppingcart.exception.AuthenticationFailedException;
import com.xaxage.shoppingcart.exception.CustomException;
import com.xaxage.shoppingcart.model.AuthenticationToken;
import com.xaxage.shoppingcart.model.User;
import com.xaxage.shoppingcart.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;

    public UserServiceImpl(UserRepository userRepository, AuthenticationService authenticationService) {
        this.userRepository = userRepository;
        this.authenticationService = authenticationService;
    }

    @Override
    @Transactional//If we create user and token wasn't created , we want user creation reverted
    public ResponseDto signUp(SignUpDto signUpDto) {
        if (Objects.nonNull(userRepository.findByEmail(signUpDto.getEmail()))) {
            throw new CustomException("Account with this email already exists!");
        }

        String encryptedPassword = signUpDto.getPassword();

        try {
            encryptedPassword = hashPassword(signUpDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new CustomException(e.getMessage());
        }

        User user = new User();
        user.setEmail(signUpDto.getEmail());
        user.setDateOfBirth(signUpDto.getDateOfBirth());
        user.setFirstName(signUpDto.getFirstName());
        user.setLastName(signUpDto.getLastName());
        user.setPassword(encryptedPassword);
        user.setId(signUpDto.getId());

        userRepository.save(user);

        final AuthenticationToken authenticationToken = new AuthenticationToken(user.getId());

        authenticationService.saveConfirmationToken(authenticationToken);


        return new ResponseDto("success", "User created!");
    }

    @Override
    public SignInResponseDto signIn(SignInDto signInDto) {
        User user = userRepository.findByEmail(signInDto.getEmail());

        if (Objects.isNull(user)) {
            throw new AuthenticationFailedException("No account with that email");
        }

        try {
            // check if password is right
            if (!user.getPassword().equals(hashPassword(signInDto.getPassword()))) {
                // passowrd doesnot match
                throw new AuthenticationFailedException("Wrong password");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        AuthenticationToken token = authenticationService.getToken(user.getId());

        if (Objects.isNull(token)) {
            throw new CustomException("Tokes wasn't found!");
        }

//        if(!Helper.notNull(token)) {
//            // token not present
//            throw new CustomException("token not present");
//        }

        return new SignInResponseDto("success", token.getToken());

    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return hash;
    }
}
