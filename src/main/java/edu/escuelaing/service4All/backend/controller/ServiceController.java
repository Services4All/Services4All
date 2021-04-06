package edu.escuelaing.service4All.backend.controller;

import edu.escuelaing.service4All.backend.model.*;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/newService")
    public void newService(Servicio servicio) {
        Servicio persistentServicio=new Servicio();
        persistentServicio.setCategoria(servicio.getCategoria());
        persistentServicio.setId(servicio.getId());
        persistentServicio.setIdusuario(servicio.getIdusuario());
        persistentServicio.setCreationdate(servicio.getCreationdate());
        persistentServicio.setIdservicio(servicio.getIdservicio());
        persistentServicio.setNombre(servicio.getNombre());
        persistentServicio.setDescripcion(servicio.getDescripcion());
        serviciosService.saveServicio(persistentServicio);
    }
}
