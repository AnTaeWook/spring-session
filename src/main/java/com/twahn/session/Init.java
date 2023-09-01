package com.twahn.session;

import com.twahn.session.entity.Employee;
import com.twahn.session.entity.UserRole;
import com.twahn.session.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Init {

    private final PasswordEncoder passwordEncoder;
    private final EmployeeRepository employeeRepository;

    @PostConstruct
    public void init() {
        employeeRepository.save(new Employee(
                UserRole.ADMIN,
                "안태욱",
                "01086138691",
                passwordEncoder.encode("1177337")
        ));
    }

}
