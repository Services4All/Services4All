package edu.escuelaing.service4All.backend.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        try {
        	suscripcionServices.saveSuscripcion(suscrip);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(SuscripcionController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }

    }

    //para usar delete pasar solo el id en JSON
    @DeleteMapping(value = "/deletesuscripcion")
    public ResponseEntity<?> deleteSusciption(@RequestBody Suscripcion suscripcion) {
            suscripcionServices.DeleteSuscripcion(suscripcion.getIdvendedor());
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
