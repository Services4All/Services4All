package edu.escuelaing.service4all.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.escuelaing.service4all.backend.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario,Integer>{
  
}