package edu.escuelaing.service4All.backend.services;


import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import edu.escuelaing.service4All.backend.Service4AllApplication;
import edu.escuelaing.service4All.backend.model.Suscripcion;
import edu.escuelaing.service4All.backend.repository.impl.SuscripcionRepositoryImpl;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Service4AllApplication.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
class SuscripcionTest {
    
    @Autowired
    SuscripcionServices suscripcionRepository;

    @Autowired
    SuscripcionRepositoryImpl suscripcionRepositoryImpl;
    //@Test
    //void creacionCompraSetYGet() throws Exception {
        //Suscripcion nuevo = new Suscripcion(1,1,new Date(0,0,0));
        //suscripcionRepository.update(nuevo);
        //nuevo.setMesesvigente(4);
        //suscripcionRepositoryImpl.save(nuevo);
        //comentario
    //}

    @Test
    void deleteSuscription(){
        Suscripcion nuevo = new Suscripcion(1,1,new Date());
        suscripcionRepositoryImpl.save(nuevo);
        suscripcionRepositoryImpl.delete(nuevo.getIdvendedor());
    }

    //@Test
    //void deleteSuscription2(){
        //Suscripcion nuevo = new Suscripcion(1,1,new Date());
        //suscripcionRepository.saveSuscripcion(nuevo);
        //suscripcionRepository.DeleteSuscripcion(1);
    //}

    

}

