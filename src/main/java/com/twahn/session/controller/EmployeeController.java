package com.twahn.session.controller;

import com.twahn.session.dto.EmployeeLoginRequestDto;
import com.twahn.session.service.EmployeeService;
import com.twahn.session.dto.EmployeeCreateRequestDto;
import com.twahn.session.entity.Employee;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Page<Employee>> findAll(Pageable pageable) {
        return ResponseEntity.ok(employeeService.findAll(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findOneById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody EmployeeCreateRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.create(dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(HttpSession session, @RequestBody EmployeeLoginRequestDto dto) {
        employeeService.login(dto);
        session.setAttribute("AUTH_KEY", employeeService.findOneByPhoneNumber(dto.phoneNumber()));
        return ResponseEntity.ok("Authentication Success");
    }

}
