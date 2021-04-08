package edu.escuelaing.service4All.backend.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import edu.escuelaing.service4All.backend.Service4AllApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Service4AllApplication.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
class CalificacionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @WithMockUser(value = "login", password = "login", roles = "ADMIN")
    @Test
    void shouldGetCalificaciones() throws Exception {
        mockMvc.perform(
                get("/calificaciones")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}

