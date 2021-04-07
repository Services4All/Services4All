package edu.escuelaing.service4All.backend.services;

import edu.escuelaing.service4All.backend.exceptions.Service4AllException;
import edu.escuelaing.service4All.backend.model.*;
import edu.escuelaing.service4All.backend.repository.impl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiciosServices {

    @Autowired
    private ServicioRepositoryImpl servicio;

    public List<Servicio> findAllServices(){
        return servicio.findAllServices();
    }

    public Servicio findServiceById(int id) throws Service4AllException {
        Servicio servicio = null;
        for(Servicio service: findAllServices()){
            if(service.getId() == id){
                servicio = service;
            }
        }
        if(servicio == null) throw new Service4AllException(Service4AllException.SERVICIO_NO_EXISTE);
        return servicio;
    }

    public List<Servicio> findAllServicesIfContainAKeyValueInName(String value) throws Service4AllException {
        List<Servicio> servicios = new ArrayList<>();
        for(Servicio service: findAllServices()){
            if(service.getNombre().contains(value)){
                servicios.add(service);
            }
        }
        if(servicios.isEmpty()) throw new Service4AllException(Service4AllException.SERVICIOS_NO_ASOCIADOS);
        return servicios;
    }

    public void saveService(Servicio newServicio){
        servicio.saveService(newServicio);

    }
 
	

}
