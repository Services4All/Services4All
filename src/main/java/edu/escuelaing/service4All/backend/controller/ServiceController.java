package edu.escuelaing.service4All.backend.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
    @GetMapping("/service")
    public String index() {
        return "services!";
    }
}