package edu.escuelaing.service4All.backend.controller;

import edu.escuelaing.service4All.backend.model.*;
import edu.escuelaing.service4All.backend.services.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class SuscripcionTest {

    @Autowired
    SuscripcionServices suscripcionServices;

    @Test
    void creacionSuscrpSetYGet() throws Exception {
        Suscripcion nuevo = new Suscripcion(222,2,new Date(0,0,0));
        Suscripcion nuevo2 = new Suscripcion();
        nuevo.setIdvendedor(3);
        nuevo.setMesesvigente(3);
        nuevo.setFechainicio(new Date(0,0,0));
        nuevo2.setIdvendedor(3);
        nuevo2.setMesesvigente(3);
        nuevo2.setFechainicio(new Date(0,0,0));
        int a = nuevo.getIdvendedor();
        int b = 3;
        suscripcionServices.findAllSuscripciones();
        assertEquals(a,b);
    }

   
}
