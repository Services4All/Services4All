package edu.escuelaing.service4all.backend.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

import edu.escuelaing.service4all.backend.model.User;
import edu.escuelaing.service4all.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{correo}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable String correo) {
        try {
            userService.isRegister(userService.getUserByCorreo(correo));
            return new ResponseEntity<>(new Gson().toJson(userService.getUserByCorreo(correo)), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("HTTP 404 Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        try {
            return new ResponseEntity<>(new Gson().toJson(userService.findAll()), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("HTTP 404 Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/registrar")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        try {
            User nuevo= new User(user.getId(),user.getFirstname(),user.getLastname(), user.getEmail(),user.getCedula(), user.getTipo(),user.getCity(),user.getPassword());
            userService.saveUser(nuevo);
            return new ResponseEntity<>( HttpStatus.OK);
        } catch (Exception e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
