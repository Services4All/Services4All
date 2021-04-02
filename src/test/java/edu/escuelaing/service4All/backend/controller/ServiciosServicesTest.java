  
package edu.escuelaing.service4All.backend.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.escuelaing.service4All.backend.model.Servicio;
import edu.escuelaing.service4All.backend.services.ServiciosServices;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

@SpringBootTest
public class ServiciosServicesTest {

    @Autowired
    private ServiciosServices serviciosServices;

    @Test
    void getServices() throws Exception {
        List<Servicio> nuevo = serviciosServices.findAllServices();
       assertTrue(nuevo!=null);
    }
 
}