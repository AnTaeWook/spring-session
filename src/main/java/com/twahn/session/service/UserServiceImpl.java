package com.twahn.session.service;

import com.twahn.session.entity.Employee;
import com.twahn.session.entity.UserDetailsImpl;
import com.twahn.session.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByPhoneNumber(username).orElseThrow();
        return createUserDetails(new UserDetailsImpl(employee));
    }

    private UserDetails createUserDetails(UserDetailsImpl userDetail) {
        return User.builder()
                .username(userDetail.getUsername())
                .password(userDetail.getPassword())
                .roles(userDetail.getEmployee().getRole().name())
                .build();
    }

}
