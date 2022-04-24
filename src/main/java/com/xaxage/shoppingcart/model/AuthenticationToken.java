package com.xaxage.shoppingcart.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "token")
public class AuthenticationToken extends BaseEntity {

    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private Long userId;

    public AuthenticationToken(Long userId) {

        this.userId = userId;
        this.token = UUID.randomUUID().toString();
    }

    public AuthenticationToken() {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long user_id) {
        this.userId = user_id;
    }
}
