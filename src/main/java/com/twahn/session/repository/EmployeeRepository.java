package com.twahn.session.repository;

import com.twahn.session.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByPhoneNumber(String phoneNumber);

}
