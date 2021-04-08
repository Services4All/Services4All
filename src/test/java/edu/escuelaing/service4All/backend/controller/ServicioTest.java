package edu.escuelaing.service4All.backend.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import edu.escuelaing.service4All.backend.Service4AllApplication;
import edu.escuelaing.service4All.backend.exceptions.Service4AllException;
import edu.escuelaing.service4All.backend.model.Servicio;
import edu.escuelaing.service4All.backend.repository.impl.ServicioRepositoryImpl;
import edu.escuelaing.service4All.backend.services.ServiciosServices;


import java.util.Date;
import java.util.List;

import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.*;


@SpringBootTest(classes = Service4AllApplication.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
class ServicioTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ServiciosServices ServiciosServices;

    @Autowired
    ServicioRepositoryImpl servicioRepositoryImpl;

   

    @Test
    void creacionServicioSetYGet() throws Exception {
        Servicio nuevo2=new Servicio(1,1,1,"asd","asda",new Date(0,0,0),"asdas");
        Servicio nuevo =new Servicio();
        nuevo.setCategoria("categoria");
        nuevo.setId(1);
        nuevo.setIdusuario(1);
        nuevo.setCreationdate(new Date(0,0,0));
        nuevo.setIdservicio(1);
        nuevo.setNombre("nombre");
        nuevo.setDescripcion("descripcion");
        nuevo.getCreationdate();
        nuevo.getId();
        nuevo.getNombre();
        nuevo.getIdservicio();
        nuevo.getIdusuario();
        assertTrue(nuevo.getCategoria().equals("categoria") && nuevo.getDescripcion().equals("descripcion"));
    }
    @Test
    void creacionServicio() throws Exception {
        Servicio nuevo2=new Servicio(1,1,1,"asd","asda",new Date(0,0,0),"asdas");
        ServiciosServices.saveService(nuevo2);
        String x = nuevo2.getDescripcion();
        String b = "asda";
        assertEquals(x,b);
    }

    @Test
    void putServicio() throws Exception {
        Servicio a = ServiciosServices.findServiceById(79);
        a.setDescripcion("Nueva");
        ServiciosServices.update(a);
        String x = a.getDescripcion();
        String b = "Nueva";
        assertEquals(x,b);
    }

    @Test
    void deleteServicio() throws Service4AllException  {
        Servicio nuevo2=new Servicio(1,1,1,"delete2","delete2",new Date(0,0,0),"delete2");

        ServiciosServices.saveService(nuevo2);
        List<Servicio> a = ServiciosServices.findAllServices();
        int aa = a.size();
        
        ServiciosServices.deleteServicio(a.get(aa-1).getId());
        List<Servicio> b = ServiciosServices.findAllServices();
        int bb = b.size();

        //int b = ServiciosServices.findAllServicesIfContainAKeyValueInName("delete").size();
        assertEquals(aa-1,bb);
    }

    @Test
    void GetServicioByCategoria() throws Exception {
        Servicio nuevo=new Servicio(1,1,1,"asd","asda",new Date(0,0,0),"CategoriaNueva");
        ServiciosServices.saveService(nuevo);
        List<Servicio> Servicios = ServiciosServices.findAllServicesByCategory("CategoriaNueva");
        assertTrue(Servicios.size()>=1);
    }

    @Test
    void GetCategorias() throws Exception {
        Servicio nuevo=new Servicio(1,1,1,"asd","asda",new Date(0,0,0),"CategoriaNueva");
        ServiciosServices.saveService(nuevo);
        List<String> Categorias = ServiciosServices.findAllCategories();
        assertTrue(Categorias.contains("CategoriaNueva"));
    }

}
