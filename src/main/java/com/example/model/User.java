package com.example.model;

import com.example.model.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private static long counterId = 1;
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String password;
    private Role role;

    public User(String fullName, String phoneNumber, String password, Role role) {
        this.id = counterId++;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

}
