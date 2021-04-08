package edu.escuelaing.service4All.backend.controller;

import edu.escuelaing.service4All.backend.model.Favorito;
import edu.escuelaing.service4All.backend.services.FavoritoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/favoritos")
public class FavoritoController {

    @Autowired
    FavoritoServices favoritosServices;

    @GetMapping
    public ResponseEntity<?> findAllFavoritos() {
        List<Favorito> favoritos = null;
        try {
            favoritos = favoritosServices.findAllFavoritos();
        } catch (Exception ex) {
            Logger.getLogger(ComentarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(favoritos, HttpStatus.ACCEPTED);
    }

    @GetMapping(path="/{id}")
    public  ResponseEntity<?>  findAllFavoritosByIdUsuario(@PathVariable int id) {
        List<Favorito> favoritos = null;
        try {
            favoritos = favoritosServices.findFavoritosByIdUsuario(id);
        } catch (Exception ex) {
            Logger.getLogger(ComentarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(favoritos, HttpStatus.ACCEPTED);
    }
}
