package edu.escuelaing.service4All.backend.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import edu.escuelaing.service4All.backend.model.*;

import edu.escuelaing.service4All.backend.services.ServiciosServices;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;

import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ComentarioControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
	ReclamoController reclamoController;


    @Test
    void getAllComentarios() throws Exception {
        Reclamo comentario = new Reclamo(1, 1, new Date(0, 0, 0), "sad", 1);
        reclamoController.findAllReclamos();
      
    }
   


}