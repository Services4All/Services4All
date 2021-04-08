package edu.escuelaing.service4All.backend.repository;

import edu.escuelaing.service4All.backend.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra,Integer> {
}
