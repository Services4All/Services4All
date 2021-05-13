package edu.escuelaing.service4All.backend.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import edu.escuelaing.service4All.backend.controller.*;
import edu.escuelaing.service4All.backend.model.Suscripcion;
import edu.escuelaing.service4All.backend.services.SuscripcionServices;

import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class SuscripcionControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    SuscripcionController suscripcionController;

    @Autowired
    SuscripcionServices suscripcionServices;

    @Test
    void getAllComentarios() throws Exception {
        suscripcionController.findAllSuscripcion();
    }
   
    @Test
    void savaSuscripcion() throws Exception {
        List<Suscripcion> all = suscripcionServices.findAllSuscripciones();
        Suscripcion res= all.get(all.size()-1);
        res.setIdvendedor(res.getIdvendedor()+1);
        suscripcionController.addSuscripcion(res);
    }
   


}