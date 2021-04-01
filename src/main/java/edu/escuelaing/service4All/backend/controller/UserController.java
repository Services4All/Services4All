package edu.escuelaing.service4All.backend.controller;

import com.google.gson.Gson;
import edu.escuelaing.service4All.backend.model.User;
import edu.escuelaing.service4All.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/{correo}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable String correo){
        try{
            userService.isRegister(userService.getUserByCorreo(correo));
            return new ResponseEntity<>(new Gson().toJson(userService.getUserByCorreo(correo)), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("HTTP 404 Not Found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> getUsers(){
        return null;
    }


}
