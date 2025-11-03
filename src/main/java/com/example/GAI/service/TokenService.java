package com.example.GAI.service;
import com.example.GAI.model.User;

public interface TokenService {

    void saveToken(String refreshToken, User user);

    void removeToken(User user);
}
