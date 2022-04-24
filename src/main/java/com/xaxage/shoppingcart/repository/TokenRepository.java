package com.xaxage.shoppingcart.repository;

import com.xaxage.shoppingcart.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findByUserId(Long userId);

    AuthenticationToken findTokenByToken(String token);
}
