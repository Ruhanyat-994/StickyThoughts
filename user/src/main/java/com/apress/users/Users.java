package com.apress.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Builder
@Data
public class Users {
    @NotBlank(message = "Email can not be empty")
    private String email;

    @NotBlank(message = "Name can not be null")
    private String name;

    @Pattern(message = "Password must be at lead 8 characters long and contain at least one number," +
            "one uppercase, one lowercase and one special character",
    regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\\\S+$).{8,}$")
    private String password;

    private String gravatarUrl;

    @Singular("role")
    private List<UserRole> userRoles;

    private boolean active;


}
