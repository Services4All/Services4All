package edu.escuelaing.service4All.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.service4All.backend.exceptions.Service4AllException;
import edu.escuelaing.service4All.backend.model.*;
import edu.escuelaing.service4All.backend.repository.impl.*;

import java.util.ArrayList;
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


    public Servicio findServiceById(int id) throws Service4AllException {
        Servicio seervicio=null;
        for(Servicio service: findAllServices()){
            if(service.getId() == id){
                seervicio = service;
            }
        }
        if(seervicio.equals(null) )throw new Service4AllException(Service4AllException.SERVICIO_NO_EXISTE);
        return seervicio;
    }

    public List<Servicio> findAllServicesIfContainAKeyValueInName(String value) throws Service4AllException {
        List<Servicio> servicios = new ArrayList<>();
        for(Servicio findServicio: findAllServices()){
            if(findServicio.getNombre().contains(value)){
                servicios.add(findServicio);
            }
        }
        if(servicios.isEmpty()) throw new Service4AllException(Service4AllException.SERVICIOS_NO_ASOCIADOS);
        return servicios;
    }
 
	

}
