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
import edu.escuelaing.service4All.backend.model.Servicio;
import edu.escuelaing.service4All.backend.repository.impl.ServicioRepositoryImpl;
import edu.escuelaing.service4All.backend.services.ServiciosServices;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ServicioTest {

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
        ServiciosServices.saveServicio(nuevo2);
       
    }

}
