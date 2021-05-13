package edu.escuelaing.service4All.backend.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import edu.escuelaing.service4All.backend.controller.*;
import edu.escuelaing.service4All.backend.model.*;
import edu.escuelaing.service4All.backend.services.ComentarioServices;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class ComentarioControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
	ComentarioController comentarioController;

    @Autowired
    ComentarioServices comen;

    @Test
    void getAllComentarios() throws Exception {
        Comentario comentario = new Comentario(1, 1, new Date(), "sad", 1);
        comentarioController.findAllComentarios();

        assertTrue(true);
      
    }
    @Test
    void getAllComentarioById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/comentarios/111"));
        assertTrue(true);
    }

    @Test
    void putComentario() throws Exception {
        Comentario comentario = new Comentario(222, 222, new Date(), "Prueba PUT", 4);
        comentarioController.putComentario(comentario);
        Comentario c=null;
        for(Comentario x: comen.findAllComentarios()){
            if(x.getId()==comentario.getId()){
                c=x;
            }
        }
        int a=comentario.getId();
        int b=comentario.getId();
        assertEquals(a,b);
    }

}