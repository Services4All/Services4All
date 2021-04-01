package edu.escuelaing.service4All.backend.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import edu.escuelaing.service4All.backend.services.ServiciosServices;
import edu.escuelaing.service4All.backend.model.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
	ServiciosServices serviciosService;

    @Test
    void getService() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/service").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("services!")));
    }
    @Test
    void getAllServices() throws Exception {
        List<Servicio> nuevo = serviciosService.findAllServices();
        ServiceController nuevo2 =new ServiceController();
        
        assertTrue(nuevo!=null && nuevo2!=null);
    }
 

}