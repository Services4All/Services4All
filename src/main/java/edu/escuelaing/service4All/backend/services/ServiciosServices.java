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


    Servicio serviceUtil;

    public List<Servicio> findAllServices(){
        return servicio.findAllServices();
    }

    public Servicio findServiceById(int id) throws Service4AllException {
        serviceUtil = null;
        for(Servicio service: findAllServices()){
            if(service.getId() == id){
                serviceUtil = service;
            }
        }
        if(serviceUtil == null) throw new Service4AllException(Service4AllException.SERVICIO_NO_EXISTE);
        return serviceUtil;
    }

    public List<Servicio> findAllServicesByCategory(String categoria) {
        List<Servicio> servicios = servicio.findAllServices();
        List<Servicio> result = new ArrayList<>();
        for (Servicio x:servicios){
            if(x.getCategoria().equals(categoria)){
                result.add(x);
            }
        }
        return result;
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

    public List<String> findAllCategories(){
        List<String> categorias = new ArrayList<>();
        List<Servicio> servicios = servicio.findAllServices();
        for (Servicio x:servicios){
            if(!categorias.contains(x.getCategoria())){
                categorias.add(x.getCategoria());
            }
        }
        return categorias;
    }

    public void saveService(Servicio newServicio){
        servicio.saveService(newServicio);

    }

    public void update(Servicio servi) throws Service4AllException {
        Servicio s = findServiceById(servi.getId());
		s.setDescripcion(servi.getDescripcion());
		servicio.saveService(s);
    }
 
	public void deleteServicio(int id){
    	servicio.delete(id);
    }

}
