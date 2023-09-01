package com.twahn.session.controller;

import com.twahn.session.entity.Employee;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    public String hello(HttpSession session) {
        Employee employee = (Employee) session.getAttribute("AUTH_KEY");
        System.out.println(employee);
        return "hello";
    }

}
