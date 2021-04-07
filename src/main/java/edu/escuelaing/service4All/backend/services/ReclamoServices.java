package edu.escuelaing.service4All.backend.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.service4All.backend.model.Reclamo;
import edu.escuelaing.service4All.backend.repository.impl.ReclamoRepositoryImpl;



@Service
public class ReclamoServices {
	@Autowired
	ReclamoRepositoryImpl reclamoRepositoryImpl;
	
	public List<Reclamo> findAllComentarios(){
        return reclamoRepositoryImpl.findAllReclamos();
    }
	public void saveComentario(Reclamo c){
		reclamoRepositoryImpl.saveReclamo(c);
	}
	
	
}