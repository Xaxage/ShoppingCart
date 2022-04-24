package com.xaxage.shoppingcart.service;

import com.xaxage.shoppingcart.model.AuthenticationToken;
import com.xaxage.shoppingcart.model.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    void saveConfirmationToken(AuthenticationToken authenticationToken);

    AuthenticationToken getToken(Long userId);

    void authenticate(String token);

    User getUser(String token);
}
