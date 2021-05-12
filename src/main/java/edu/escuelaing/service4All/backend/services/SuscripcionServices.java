package edu.escuelaing.service4All.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.service4All.backend.model.Suscripcion;
import edu.escuelaing.service4All.backend.repository.impl.SuscripcionRepositoryImpl;

@Service
public class SuscripcionServices {

    @Autowired
	SuscripcionRepositoryImpl suscripcionRepositoryImpl;

    public List<Suscripcion> findAllSuscripciones(){
        return suscripcionRepositoryImpl.findAllSuscripciones();
        }
    
}
