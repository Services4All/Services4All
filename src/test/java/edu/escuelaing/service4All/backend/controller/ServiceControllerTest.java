package edu.escuelaing.service4all.backend.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import edu.escuelaing.service4all.backend.services.ServiciosServices;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
	ServiciosServices serviciosService;

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

    @WithMockUser(value = "prueba@mail.com",password = "12345", roles = "ADMIN")
    @Test
    void shouldGetServiceById() throws Exception {
        mvc.perform(
                get("/service/79")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @WithMockUser(value = "prueba@mail.com",password = "12345", roles = "ADMIN")
    @Test
    void shouldGetAllServicesIfContainAKeyValueInName() throws Exception {
        mvc.perform(
                get("/services/a")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @WithMockUser(value = "prueba@mail.com",password = "12345", roles = "ADMIN")
    @Test
    void shouldNotGetServiceById() throws Exception {
        mvc.perform(
                get("/service/10000000")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

    @WithMockUser(value = "prueba@mail.com",password = "12345", roles = "ADMIN")
    @Test
    void shouldNotGetAllServicesIfContainAKeyValueInName() throws Exception {
        mvc.perform(
                get("/services/aaaaa")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


}