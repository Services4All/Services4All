package edu.escuelaing.service4All.backend.services;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import edu.escuelaing.service4All.backend.Service4AllApplication;
import edu.escuelaing.service4All.backend.exceptions.Service4AllException;
import edu.escuelaing.service4All.backend.model.Calificacion;
import edu.escuelaing.service4All.backend.security.UserDetailsServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Service4AllApplication.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class CalificacionServiceTest {
    @Autowired
    CalificacionesServices calificacionesServices;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Test
    public void shouldFindAll() throws Service4AllException {
        int a = calificacionesServices.findAll().size();
        Assert.assertTrue(a > 0);
    }

    @Test
    void shouldSave() throws Service4AllException {
        Calificacion c = new Calificacion(1,1,1,20);
        c.setCalificacion(c.getCalificacion());
        c.setId(c.getId());
        c.setIdservicio(c.getIdservicio());
        c.setIdusuario(c.getIdusuario());
        int a = calificacionesServices.findAll().size();
        calificacionesServices.saveCalificacion(c);
        int b = calificacionesServices.findAll().size();
        Assert.assertEquals(a+1,b);
    }

    

}

