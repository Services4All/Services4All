package edu.escuelaing.service4All.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.service4All.backend.model.Suscripcion;
import edu.escuelaing.service4All.backend.services.SuscripcionServices;

@RestController
@RequestMapping("/suscripciones")
public class SuscripcionController {

    @Autowired
    SuscripcionServices suscripcionServices;

    @GetMapping
    public  List<Suscripcion>  findAllSuscripcion() {
        List<Suscripcion> suscripcion = suscripcionServices.findAllSuscripciones();
       return suscripcion;
    }
    
}
