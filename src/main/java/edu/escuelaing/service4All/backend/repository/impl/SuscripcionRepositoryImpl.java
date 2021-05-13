package edu.escuelaing.service4All.backend.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.service4All.backend.model.Suscripcion;
import edu.escuelaing.service4All.backend.repository.SuscripcionRepository;

@Service
public class SuscripcionRepositoryImpl {

    @Autowired
	SuscripcionRepository suscripcionRepository;

    public List<Suscripcion> findAllSuscripciones() {
		return suscripcionRepository.findAll();
	}

    public void save(Suscripcion suscrip) {
		suscripcionRepository.save(suscrip);
    }

  

}
