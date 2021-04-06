package edu.escuelaing.service4All.backend.controller;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import edu.escuelaing.service4All.backend.exceptions.Service4AllException;
import edu.escuelaing.service4All.backend.services.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path="/{correo}")
    public String getUser(@PathVariable String correo) throws Service4AllException {
        
            userService.isRegister(userService.getUserByCorreo(correo));
            return new Gson().toJson(userService.getUserByCorreo(correo));
        
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        try {
            return new ResponseEntity<>(new Gson().toJson(userService.findAll()), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("HTTP 404 Not Found", HttpStatus.NOT_FOUND);
        }
    }

}
