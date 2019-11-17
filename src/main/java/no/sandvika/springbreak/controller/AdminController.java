package no.sandvika.springbreak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world!";
    }

}