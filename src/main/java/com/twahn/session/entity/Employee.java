package com.twahn.session.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String name;

    @Column(unique = true)
    private String phoneNumber;

    private String password;

    public Employee(UserRole role, String name, String phoneNumber, String password) {
        this.role = role;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

}
