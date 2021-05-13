package edu.escuelaing.service4All.backend.controller;

import java.util.List;
// import java.util.logging.Level;
// import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @PutMapping(value = "/putsuscripcion")
    public ResponseEntity<?> putService(@RequestBody Suscripcion suscripcion) {
        try {
            suscripcionServices.update(suscripcion);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
           // Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/addsuscripcion",method = RequestMethod.POST)
    public ResponseEntity<?> addSuscripcion(@RequestBody Suscripcion suscrip){
        // try {
        	suscripcionServices.saveSuscripcion(suscrip);
            return new ResponseEntity<>(HttpStatus.CREATED);
        // } catch (Exception ex) {
        //     Logger.getLogger(SuscripcionController.class.getName()).log(Level.SEVERE, null, ex);
        //     return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        // }

    }
    
}
