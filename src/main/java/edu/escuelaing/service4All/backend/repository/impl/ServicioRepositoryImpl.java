package edu.escuelaing.service4All.backend.repository.impl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import edu.escuelaing.service4All.backend.model.*;
import edu.escuelaing.service4All.backend.repository.*;

import java.util.List;

@Service 
public class ServicioRepositoryImpl{

	 @Autowired
	 ServicioRepository servicioRepository;
	 
	 public List<Servicio> findAllServices() {
	       return servicioRepository.findAll();
	  }

	public void saveServicio(Servicio newServicio) {
		servicioRepository.save(newServicio);
	}

   
}