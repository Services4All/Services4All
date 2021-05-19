package edu.escuelaing.service4All.backend.repository.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.escuelaing.service4All.backend.model.Reclamo;
import edu.escuelaing.service4All.backend.repository.ReclamoRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
public class ReclamoRepositoryImpl{
	
	@Autowired
    ReclamoRepository reclamoRepository;
	
	public List<Reclamo> findAllReclamos() {
        return  reclamoRepository.findAll();
    }
    public void saveReclamo(Reclamo reclamo) {
    	LocalDate creationDate = LocalDate.now();
		  
		reclamo.setCreationdate(Date.valueOf(creationDate));
        reclamoRepository.save(reclamo);
    }
  
    public void deleteReclamo(int reclamo) {
        reclamoRepository.deleteById(reclamo);
    }
	

}