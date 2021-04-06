package edu.escuelaing.service4All.backend.controller;

import com.google.gson.Gson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.service4All.backend.exceptions.Service4AllException;
import edu.escuelaing.service4All.backend.model.*;
import edu.escuelaing.service4All.backend.services.ServiciosServices;

@RestController
public class ServiceController {
    @Autowired
	ServiciosServices serviciosService;
    
    @GetMapping("/service")
    public String index() {
        return "services!";
    }

    @GetMapping("/services")
    public List<Servicio> getAllServices() {
        return serviciosService.findAllServices();
    }
  


    @GetMapping("/service/{id}")
    public  String getServiceById(@PathVariable int id) throws Service4AllException{
 
            return new Gson().toJson(serviciosService.findServiceById(id));
       
    }

    @GetMapping("/services/{value}")
    public  String getAllServicesIfContainAKeyValueInName(@PathVariable String value) throws Service4AllException{
        return new Gson().toJson(serviciosService.findAllServicesIfContainAKeyValueInName(value));
    }

}
