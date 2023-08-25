package com.twahn.session.service;

import com.twahn.session.dto.EmployeeCreateRequestDto;
import com.twahn.session.entity.Employee;
import com.twahn.session.entity.UserRole;
import com.twahn.session.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Employee findOneById(Long id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Employee create(EmployeeCreateRequestDto dto) {
        return employeeRepository.save(
                new Employee(UserRole.MANAGER, dto.name(), dto.phoneNumber(), dto.registrationNumber())
        );
    }

    @Transactional
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

}
