  
package edu.escuelaing.service4All.backend.controller;
import edu.escuelaing.service4All.backend.Service4AllApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.escuelaing.service4All.backend.model.Servicio;
import edu.escuelaing.service4All.backend.services.ServiciosServices;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Service4AllApplication.class)
public class ServiciosServicesTest {

    @Autowired
    private ServiciosServices serviciosServices;

    @Test
    void getServices() throws Exception {
        List<Servicio> nuevo = serviciosServices.findAllServices();
       assertTrue(nuevo!=null);
    }
 
}