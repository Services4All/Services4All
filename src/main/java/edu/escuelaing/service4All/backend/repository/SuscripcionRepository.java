package edu.escuelaing.service4All.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.escuelaing.service4All.backend.model.Suscripcion;

@Repository
public interface SuscripcionRepository extends JpaRepository<Suscripcion,Integer>{

}
