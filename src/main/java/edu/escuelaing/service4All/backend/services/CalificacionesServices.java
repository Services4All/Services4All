package edu.escuelaing.service4All.backend.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.service4All.backend.model.Calificacion;
import edu.escuelaing.service4All.backend.repository.CalificacionRepository;



@Service
public class CalificacionesServices {
	@Autowired
	CalificacionRepository calificacionRepository;
	
	public List<Calificacion> findAllCalificaciones(){
        return calificacionRepository.findAll();
    }
	public void saveCalificacion(Calificacion c){
		calificacionRepository.save(c);
	}
	

}
