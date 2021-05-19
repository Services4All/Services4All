package edu.escuelaing.service4All.backend.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import edu.escuelaing.service4All.backend.model.*;

import java.sql.Date;
import java.util.List;

import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ReclamoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
	ReclamoController reclamoController;


    @Test
    void getAllComentarios() throws Exception {

        Reclamo reclamo = new Reclamo(1, 1, new Date(0, 0, 0), "sad", 1);
        reclamoController.findAllReclamos();
      
    }

    @Test
    void deleteReclamo() throws Exception {
        List<Reclamo> all = reclamoController.findAllReclamos();
        Reclamo res= all.get(1);
        reclamoController.deleteReclamo(res);
    }
   


}