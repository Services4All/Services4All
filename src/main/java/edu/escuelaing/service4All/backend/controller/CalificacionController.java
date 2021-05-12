package edu.escuelaing.service4All.backend.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.escuelaing.service4All.backend.model.Calificacion;
import edu.escuelaing.service4All.backend.services.CalificacionesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired
    CalificacionesServices calificacionesServices;

  
    @GetMapping
    public  List<Calificacion>  findAllCalificaciones() {
        List<Calificacion> calificacion = calificacionesServices.findAllCalificaciones();
       return calificacion;
    }
    @PostMapping(value = "/nuevaCalificacion")
    public ResponseEntity<?> reservar(@RequestBody Calificacion calif) {
        try {
            calificacionesServices.saveCalificacion(calif);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(ReclamoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }
    }

}
