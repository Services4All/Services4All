package edu.escuelaing.service4All.backend.controller;

import edu.escuelaing.service4All.backend.services.FavoritoServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class FavoritoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    FavoritoServices favoritoServices;

    @WithMockUser(value = "prueba@mail.com",password = "12345", roles = "ADMIN")
    @Test
    void getAllFavoritos() throws Exception {
        mvc.perform(
                get("/favoritos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
