package edu.escuelaing.service4All.backend.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import edu.escuelaing.service4All.backend.model.*;

import java.sql.Date;

import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ComentarioControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
	ComentarioController comentarioController;


    @Test
    void getAllComentarios() throws Exception {
        Comentario comentario = new Comentario(1, 1, new Date(0, 0, 0), "sad", 1);
        comentarioController.findAllComentarios();
        comentarioController.findAllComentariosById(111);
        comentarioController.addComentario(comentario);
      
    }
    @Test
    void getAllComentarioById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/comentarios/111"));
    }


}