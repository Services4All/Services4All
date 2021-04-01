package edu.escuelaing.service4All.backend.controller;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import edu.escuelaing.service4All.backend.model.Servicio;


@SpringBootTest
public class ServicioTest {


    @Test
    void pruebaCreacionServicio() throws Exception {
        Servicio nuevo =new Servicio(1,1,"nuevo","nuevo servicio",new Date(0, 0, 0));
        assertTrue(nuevo.getDescripcion().equals("nuevo servicio") && nuevo.getNombre().equals("nuevo"));
    }
    @Test
    void pruebaId() throws Exception {
        Servicio nuevo =new Servicio(1,1,"nuevo","nuevo servicio",new Date(0, 0, 0));
        assertTrue(nuevo.getId()==1);
    }
    @Test
    void pruebaIdVendedor() throws Exception {
        Servicio nuevo =new Servicio(1,1,"nuevo","nuevo servicio",new Date(0, 0, 0));
        assertTrue(nuevo.getIdVendedor()==1);
    }
    @Test
    void pruebaDate() throws Exception {
        Servicio nuevo =new Servicio(1,1,"nuevo","nuevo servicio",new Date(0, 0, 0));
        assertTrue(nuevo.getCreacion().equals(new Date(0, 0, 0)));
    }
}