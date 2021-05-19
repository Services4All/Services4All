package edu.escuelaing.service4All.backend.controller;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.service4All.backend.model.Reclamo;
import edu.escuelaing.service4All.backend.services.ReclamoServices;


@RestController
@RequestMapping(value = "/reclamos")
public class ReclamoController {
	@Autowired
	ReclamoServices reclamoServices;
	
    @GetMapping
    public  List<Reclamo>  findAllReclamos() {
        List<Reclamo> reclamos = reclamoServices.findAllComentarios();
       return reclamos;
    }

    
	@RequestMapping(value="/addReclamo",method = RequestMethod.POST)
    public ResponseEntity<?> addReclamo(@RequestBody Reclamo reclamo){
        try {
        	reclamoServices.saveComentario(reclamo);;
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(ReclamoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }

    }

    //para usar delete pasar solo el id en JSON
    @DeleteMapping(value = "/deleteReclamo")
    public ResponseEntity<?> deleteReclamo(@RequestBody Reclamo reclamo) {
        reclamoServices.deleteReclamo(reclamo.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
   
}
