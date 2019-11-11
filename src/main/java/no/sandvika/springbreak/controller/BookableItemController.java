package no.sandvika.springbreak.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookableItemController {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello world!";
    }
}