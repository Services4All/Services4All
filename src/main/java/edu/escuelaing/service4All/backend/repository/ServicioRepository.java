package edu.escuelaing.service4All.backend.repository;

import java.util.List;
import edu.escuelaing.service4All.backend.model.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface ServicioRepository  extends JpaRepository<Servicio,Integer> {
   
	
}