package com.example.__spring_security.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class UserRegistrationDto {

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min=6, message = "Password should have at least 6 characters")
    private String password;

    @NotBlank(message = "Role is mandatory")
    private String role;

    // getters and setters


    public @NotBlank(message = "Username is mandatory") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Username is mandatory") String username) {
        this.username = username;
    }

    public @NotBlank(message = "Password is mandatory") @Size(min = 6, message = "Password should have at least 6 characters") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is mandatory") @Size(min = 6, message = "Password should have at least 6 characters") String password) {
        this.password = password;
    }

    public @NotBlank(message = "Role is mandatory") String getRole() {
        return role;
    }

    public void setRole(@NotBlank(message = "Role is mandatory") String role) {
        this.role = role;
    }
}
