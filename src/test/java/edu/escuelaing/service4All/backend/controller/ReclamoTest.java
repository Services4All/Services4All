package edu.escuelaing.service4All.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Date;
import edu.escuelaing.service4All.backend.model.*;
import edu.escuelaing.service4All.backend.repository.impl.ReclamoRepositoryImpl;
import edu.escuelaing.service4All.backend.services.ReclamoServices;
import static org.junit.Assert.assertTrue;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ReclamoTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ReclamoServices reclamoServices;

    @Autowired
    ReclamoRepositoryImpl reclamoRepositoryImpl;

    @Test
    void creacionReclamoSetYGet() throws Exception {
        Reclamo nuevo2 = new Reclamo(1, 1, new Date(0, 0, 0), "sad", 1);
        Reclamo nuevo = new Reclamo();
        nuevo.setReclamo("reclamo");
        nuevo.setCreationdate(new Date(0, 0, 0));
        nuevo.setId(1);
        nuevo.setIdservicio(1);
        nuevo.setIdusuario(1);
        nuevo.getCreatioDate();
        nuevo.getIdusuario();
        nuevo.getReclamo();
        assertTrue(nuevo.getId() == 1 && nuevo.getIdservicio() == 1);
    }

   
    @Test
    void creacionComentarioServicesImpl() throws Exception {
        Reclamo nuevo2 = new Reclamo(222, 222, new Date(0, 0, 0), "sad", 222);
        reclamoRepositoryImpl.findAllReclamos();
        reclamoServices.findAllComentarios();
        reclamoServices.saveComentario(nuevo2);
        reclamoRepositoryImpl.saveReclamo(nuevo2);
    }

}
