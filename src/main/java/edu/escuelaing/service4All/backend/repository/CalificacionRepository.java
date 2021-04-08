package edu.escuelaing.service4All.backend.repository;


import edu.escuelaing.service4All.backend.model.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalificacionRepository extends JpaRepository<Calificacion,Integer> { 
    
}
