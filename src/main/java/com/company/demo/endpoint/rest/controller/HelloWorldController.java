package com.company.demo.endpoint.rest.controller;

import com.company.demo.endpoint.event.EventProducer;
import com.company.demo.endpoint.event.model.SendEmailRequested;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloWorldController {
  private final EventProducer<SendEmailRequested> eventProducer;

  @GetMapping("/hello")
  @SneakyThrows
  public String helloWorld(@RequestParam String to) {
    var event = SendEmailRequested.builder().to(to).build();
    eventProducer.accept(List.of(event));
    return "... world!";
  }
}
