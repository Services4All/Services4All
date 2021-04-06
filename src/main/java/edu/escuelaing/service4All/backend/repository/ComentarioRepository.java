package edu.escuelaing.service4All.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.escuelaing.service4All.backend.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario,Integer>{
  
}