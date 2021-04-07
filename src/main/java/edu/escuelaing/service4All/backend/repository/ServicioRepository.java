package edu.escuelaing.service4all.backend.repository;

import edu.escuelaing.service4all.backend.model.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository  extends JpaRepository<Servicio,Long> {
   
	
}