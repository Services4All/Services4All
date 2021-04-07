package edu.escuelaing.service4All.backend.repository.impl;

import edu.escuelaing.service4All.backend.model.*;
import edu.escuelaing.service4All.backend.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service 
public class ServicioRepositoryImpl{

	 @Autowired
	 ServicioRepository servicioRepository;
	 
	 public List<Servicio> findAllServices() {
	       return servicioRepository.findAll();
	  }

	
	  public void saveService(Servicio newServicio){
		servicioRepository.save(newServicio);
	  }

   
}