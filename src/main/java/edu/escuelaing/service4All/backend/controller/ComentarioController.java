package edu.escuelaing.service4All.backend.controller;


import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.service4All.backend.model.Comentario;
import edu.escuelaing.service4All.backend.services.ComentarioServices;


@RestController
@RequestMapping(value = "/comentarios")
public class ComentarioController {
	@Autowired
	ComentarioServices comentarioServices;
	
    @GetMapping
    public  ResponseEntity<?>  findAllComentarios() {
        List<Comentario> comentarios = null;
        try {
            comentarios = comentarioServices.findAllComentarios();
        } catch (Exception ex) {
        	Logger.getLogger(ComentarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comentarios, HttpStatus.ACCEPTED);
    }

	@GetMapping(path="/{id}")
    public  ResponseEntity<?>  findAllComentariosById(@PathVariable int id) {
        Optional<Comentario> comentarios;
        try {
            comentarios = comentarioServices.findAllComentariosById(id);
        } catch (Exception ex) {
        	Logger.getLogger(ComentarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comentarios, HttpStatus.ACCEPTED);
    }
	
    @PostMapping(path="/comentarioNuevo")
    public ResponseEntity<?> addComentario(@RequestBody Comentario comentario){
        try {
            Comentario nuevo= comentario;
        	comentarioServices.saveComentario(nuevo);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(ComentarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }

    }
}
