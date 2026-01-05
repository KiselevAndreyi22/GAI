package com.example.GAI.dto.response.userDto;

import com.example.GAI.model.employeeModel.Role;
import com.example.GAI.model.userModel.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String username;
    private String email;
    private Role role;

    public UserDto() {}

    public UserDto(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.role = user.getRole();
    }
}