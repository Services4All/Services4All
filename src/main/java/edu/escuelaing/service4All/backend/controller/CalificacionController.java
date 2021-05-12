package edu.escuelaing.service4All.backend.controller;

import com.google.gson.Gson;

import edu.escuelaing.service4All.backend.model.Calificacion;
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
    public ResponseEntity<String> getCalificaciones() {

        return new ResponseEntity<>(new Gson().toJson(calificacionesServices.findAllCalificaciones()), HttpStatus.OK);

    }
    @PostMapping(value = "/nuevaCalificacion")
    public ResponseEntity<?> reservar(@RequestBody Calificacion calif) {
        try {
            calificacionesServices.saveCalificacion(calif);
            return new ResponseEntity(calif,HttpStatus.CREATED);
        } catch (Exception e) {
            //Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
