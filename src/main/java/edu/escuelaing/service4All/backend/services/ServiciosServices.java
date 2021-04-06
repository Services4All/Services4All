package edu.escuelaing.service4All.backend.services;

import edu.escuelaing.service4All.backend.model.*;
import edu.escuelaing.service4All.backend.repository.impl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosServices {

    @Autowired
    private ServicioRepositoryImpl servicio;

    public List<Servicio> findAllServices(){
        return servicio.findAllServices();
    }

    public void saveServicio(Servicio newServicio) {
        servicio.saveServicio(newServicio);
    }

 
	

}
