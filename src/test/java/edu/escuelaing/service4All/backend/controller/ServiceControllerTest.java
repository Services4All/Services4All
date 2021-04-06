package edu.escuelaing.service4All.backend.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import edu.escuelaing.service4All.backend.model.Servicio;
import edu.escuelaing.service4All.backend.services.ServiciosServices;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;

import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
	ServiciosServices serviciosService;

    @Autowired
    ServiceController serviceController;

    @WithMockUser(value = "prueba@mail.com",password = "12345", roles = "ADMIN")
    @Test
    void getService() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/service").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("services!")));
    }

    @WithMockUser(value = "prueba@mail.com",password = "12345", roles = "ADMIN")
    @Test
    void getAllServices() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/services").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
              
    }

    @Test
    void addService() throws Exception {
        Servicio nuevo2=new Servicio(1,1,1,"asd","asda",new Date(0,0,0),"asdas");
        serviceController.newService(nuevo2);
              
    }

}