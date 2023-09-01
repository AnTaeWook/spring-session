package com.twahn.session.dto;

public record EmployeeLoginRequestDto(
        String phoneNumber,
        String password
) {
}
