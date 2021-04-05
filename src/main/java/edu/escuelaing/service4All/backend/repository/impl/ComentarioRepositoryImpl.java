package edu.escuelaing.service4All.backend.repository.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.escuelaing.service4All.backend.model.Comentario;
import edu.escuelaing.service4All.backend.repository.ComentarioRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ComentarioRepositoryImpl{
	
	@Autowired
    ComentarioRepository comentarioRepository;
	
	public List<Comentario> findAllComentarios() {
        return  comentarioRepository.findAll();
    }
    public void saveComentario(Comentario comentario) {
    	LocalDate creationDate = LocalDate.now();
		  
		comentario.setFecha(Date.valueOf(creationDate));
        comentarioRepository.save(comentario);
    }
	public Optional<Comentario>  findAllComentariosById(int id) {
		//Optional<Comentario> res =
		List<Comentario> res= new ArrayList<Comentario>();
		for (Comentario c: comentarioRepository.findAll()) {
			if(c.getIdservicio()==id) {
				res.add(c);
				
			}
		}
		
		Optional<Comentario> re= res.stream().findAny();
		
		return  re;
		
		
	}
}