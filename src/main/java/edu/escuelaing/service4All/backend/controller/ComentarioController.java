package edu.escuelaing.service4All.backend.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.service4All.backend.model.Comentario;
import edu.escuelaing.service4All.backend.services.ComentarioServices;


@RestController
@RequestMapping(value = "/comentarios")
public class ComentarioController {
	@Autowired
	ComentarioServices comentarioServices;
	
    @GetMapping
    public List<Comentario>   findAllComentarios() {
        List<Comentario> comentarios = null;
      
            comentarios = comentarioServices.findAllComentarios();
      
        return comentarios;
    }

	@GetMapping(path="/{id}")
    public  Optional<Comentario>  findAllComentariosById(@PathVariable int id) {
        Optional<Comentario> comentarios;
     
            comentarios = comentarioServices.findAllComentariosById(id);
        
        return comentarios;
    }
	
    @PostMapping(path="/comentarioNuevo")
    public void addComentario(Comentario comentario){
 
            Comentario persistentComentario= new Comentario();
            persistentComentario.setComentario(comentario.getComentario());
            persistentComentario.setFecha(comentario.getFecha());
            persistentComentario.setId(comentario.getId());
            persistentComentario.setIdservicio(comentario.getIdservicio());
            persistentComentario.setIdusuario(comentario.getIdusuario());
            persistentComentario.setComentario(comentario.getComentario());
        	comentarioServices.saveComentario(persistentComentario);
         

    }
}
