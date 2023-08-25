package com.twahn.session.dto;

public record EmployeeCreateRequestDto(
        String name,
        String phoneNumber,
        String registrationNumber
) {
}
