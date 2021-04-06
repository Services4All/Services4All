package edu.escuelaing.service4All.backend.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Date;
import edu.escuelaing.service4All.backend.model.*;
import edu.escuelaing.service4All.backend.services.ComentarioServices;
import edu.escuelaing.service4All.backend.services.ServiciosServices;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ComentarioTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ComentarioServices comentarioServices;


    @Test
    void creacionComentarioSetYGet() throws Exception {
        Comentario nuevo =new Comentario();
        nuevo.setComentario("comentario");
        nuevo.setFecha(new Date(0,0,0));
        nuevo.setId(1);
        nuevo.setIdservicio(1);
        nuevo.setIdusuario(1);
        nuevo.getFecha();
      
        assertTrue(nuevo.getId()==1 && nuevo.getIdservicio()==1 && nuevo.getComentario().equals("comentario"));
    }
    @Test
    void creacionComentarioServicesSetYGet() throws Exception {
       
    }


}
