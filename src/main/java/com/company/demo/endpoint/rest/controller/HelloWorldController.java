package com.company.demo.endpoint.rest.controller;

import com.company.demo.mail.Email;
import com.company.demo.mail.Mailer;
import jakarta.mail.internet.InternetAddress;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloWorldController {
    private final Mailer mailer;

    @GetMapping("/hello")
    @SneakyThrows
    public String helloWorld(@RequestParam String to) {
        var email =
                new Email(new InternetAddress(to), List.of(), List.of(), "Hello world", "... world!", List.of());

        mailer.accept(email);
        return "... world!";
    }
}

