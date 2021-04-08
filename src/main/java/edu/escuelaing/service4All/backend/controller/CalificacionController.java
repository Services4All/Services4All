package edu.escuelaing.service4All.backend.controller;

import com.google.gson.Gson;

import edu.escuelaing.service4All.backend.services.CalificacionesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired
    CalificacionesServices calificacionesServices;

    @GetMapping
    public ResponseEntity<?> getCalificaciones() {

        return new ResponseEntity<>(new Gson().toJson(calificacionesServices.findAll()), HttpStatus.OK);

    }

}
