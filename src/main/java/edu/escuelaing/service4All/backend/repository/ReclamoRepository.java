package edu.escuelaing.service4All.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.escuelaing.service4All.backend.model.Reclamo;

public interface ReclamoRepository extends JpaRepository<Reclamo,Integer>{
  
}