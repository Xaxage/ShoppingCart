package com.xaxage.shoppingcart.service;

import com.xaxage.shoppingcart.exception.AuthenticationFailedException;
import com.xaxage.shoppingcart.model.AuthenticationToken;
import com.xaxage.shoppingcart.model.User;
import com.xaxage.shoppingcart.repository.TokenRepository;
import com.xaxage.shoppingcart.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;

    public AuthenticationServiceImpl(TokenRepository tokenRepository, UserRepository userRepository) {
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
//        tokenRepository.save(authenticationToken); //todo: THIS WONT SAVE. THROWS WEIRD EXCEPTION
    }

    @Override
    public AuthenticationToken getToken(Long userId) {
        return tokenRepository.findByUserId(userId);
    }

    public User getUser(String token) {
        AuthenticationToken authenticationToken = tokenRepository.findTokenByToken(token);
        if (Objects.isNull(authenticationToken)) {
            userRepository.findById(authenticationToken.getUserId());
        }
        return null;
    }

    public void authenticate(String token) throws AuthenticationFailedException {
        if (Objects.isNull(token)) {
            throw new AuthenticationFailedException("Authentication token was not found!");
        }
        if (Objects.isNull(getUser(token))) {
            throw new AuthenticationFailedException("Authentication token is not valid!");
        }
    }
}
