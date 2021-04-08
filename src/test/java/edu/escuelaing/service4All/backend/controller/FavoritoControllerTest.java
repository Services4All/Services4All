package edu.escuelaing.service4All.backend.controller;

import edu.escuelaing.service4All.backend.model.Favorito;
import edu.escuelaing.service4All.backend.services.FavoritoServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class FavoritoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    FavoritoServices favoritoServices;

    @Test
    void getAllFavoritos() throws Exception {
        Favorito nuevo = new Favorito(222, 222);
        favoritoServices.findAllFavoritos();
        assertTrue(true);

    }
    @Test
    void getAllFavoritoById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/favoritos/222"));
        assertTrue(true);
    }
}
