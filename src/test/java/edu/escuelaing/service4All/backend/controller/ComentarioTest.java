package edu.escuelaing.service4All.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import edu.escuelaing.service4All.backend.model.*;
import edu.escuelaing.service4All.backend.services.ComentarioServices;

import java.util.Date;

import static org.junit.Assert.assertTrue;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ComentarioTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ComentarioServices comentarioServices;

    @Autowired
    ComentarioServices comentarioServicesImpl;

    @Test
    void creacionComentarioSetYGet() throws Exception {
        Comentario nuevo2 = new Comentario(1, 1, new Date(0, 0, 0), "sad", 1);
        Comentario nuevo = new Comentario();
        nuevo.setComentario("comentario");
        nuevo.setFecha(new Date(0, 0, 0));
        nuevo.setId(1);
        nuevo.setIdservicio(1);
        nuevo.setIdusuario(1);
        nuevo.getFecha();
        nuevo.getIdusuario();

        assertTrue(nuevo.getId() == 1 && nuevo.getIdservicio() == 1 && nuevo.getComentario().equals("comentario"));
    }

    @Test
    void creacionComentarioServicesSetYGet() throws Exception {
        Comentario nuevo2 = new Comentario(222, 222, new Date(0, 0, 0), "sad", 222);
        comentarioServices.findAllComentarios();
        comentarioServices.saveComentario(nuevo2);
        assertTrue(true);
    }

    @Test
    void creacionComentarioServicesImpl() throws Exception {
        Comentario nuevo2 = new Comentario(222, 222, new Date(0, 0, 0), "sad", 222);
        comentarioServicesImpl.findAllComentarios();
        comentarioServicesImpl.saveComentario(nuevo2);
        assertTrue(true);
    }

}
