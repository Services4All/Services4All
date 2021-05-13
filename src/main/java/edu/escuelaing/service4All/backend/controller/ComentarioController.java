package edu.escuelaing.service4All.backend.controller;


import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.escuelaing.service4All.backend.model.Suscripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	
	@RequestMapping(value="/comentarioNuevo",method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody Comentario comentario){
        try {
        	comentarioServices.saveComentario(comentario);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(ComentarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping(value = "/putComentario")
    public ResponseEntity<?> putComentario(@RequestBody Comentario comentario) {
        try {
            comentarioServices.update(comentario);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(ComentarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //para usar delete pasar solo el id en JSON
    @DeleteMapping(value = "/deleteComentario")
    public ResponseEntity<?> deleteComentario(@RequestBody Comentario comentario) {
        comentarioServices.deleteComentario(comentario.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
