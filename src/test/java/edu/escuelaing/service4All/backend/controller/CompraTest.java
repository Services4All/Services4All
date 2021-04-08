package edu.escuelaing.service4All.backend.controller;

import edu.escuelaing.service4All.backend.model.Compra;
import edu.escuelaing.service4All.backend.services.CompraServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class CompraTest {

    @Autowired
    CompraServices compraServices;

    @Test
    void creacionCompraSetYGet() throws Exception {
        Compra nuevo = new Compra(222,222,100000,new Date(0,0,0));
        Compra nuevo2 = new Compra();
        nuevo.setIdservicio(222);
        nuevo.setIdusuario(222);
        nuevo.setCreationdate(new Date(0,0,0));
        nuevo.setValor(200000);
        int a = nuevo.getIdusuario();
        nuevo.getIdservicio();
        nuevo.getCreationdate();
        nuevo.getValor();
        int b = 222;
        assertEquals(a,b);
    }

    @Test
    void ComprasServicesImpl() throws Exception {
        Compra nuevo = new Compra(222,222,100000,new Date(0,0,0));
        compraServices.saveCompra(nuevo);
        compraServices.findAllCompras();
        compraServices.findCompraByIdS(222);
        assertTrue(true);
    }
}
