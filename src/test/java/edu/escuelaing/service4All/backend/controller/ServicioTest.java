package edu.escuelaing.service4All.backend.controller;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import edu.escuelaing.service4All.backend.Service4AllApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import edu.escuelaing.service4All.backend.model.Servicio;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Service4AllApplication.class)
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
    @Test
    void pruebaSet() throws Exception {
        Servicio nuevo =new Servicio(1,1,"nuevo","nuevo servicio",new Date(0, 0, 0));
        nuevo.setCreacion(new Date(1, 1, 1));
        nuevo.setDescripcion("nueva Descripcion");
        nuevo.setId(2);
        nuevo.setIdVendedor(2);
        nuevo.setNombre("nombre");
        //Servicio nuevo2 = new Servicio(2,2,"nombre","nueva Descripcion",new Date(1, 1, 1));
        assertTrue(nuevo.getId()==2 && nuevo.getIdVendedor()==2 && nuevo.getNombre().equals("nombre"));
    }
}