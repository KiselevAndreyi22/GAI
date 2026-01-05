package com.example.GAI.service;
import com.example.GAI.model.userModel.User;

public interface TokenService {

    void saveToken(String refreshToken, User user);

    void removeToken(User user);
}
