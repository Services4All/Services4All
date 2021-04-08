package edu.escuelaing.service4All.backend.controller;

import edu.escuelaing.service4All.backend.model.Compra;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class CompraControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    CompraController compraController;

    @WithMockUser(value = "prueba@mail.com",password = "12345", roles = "ADMIN")
    @Test
    void getAllCompras() throws Exception {
        Compra nuevo = new Compra(222,222,100000,new Date(0,0,0));
        compraController.getAllComprass();
        compraController.findComprasByIdServicio(222);
        mvc.perform(
                get("/compras")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
