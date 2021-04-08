package edu.escuelaing.service4All.backend.controller;

import com.google.gson.Gson;
import edu.escuelaing.service4All.backend.services.FavoritoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "/favoritos")
public class FavoritoController {

    @Autowired
    FavoritoServices favoritosServices;

    @GetMapping()
    public ResponseEntity<String> getAllFavoritos(){
        return new ResponseEntity<>(new Gson().toJson(favoritosServices.findAllFavoritos()), HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public  ResponseEntity<String>  findServiciosByIdUsuario(@PathVariable int id) {
        return new ResponseEntity<>(new Gson().toJson(favoritosServices.findFavoritosByIdUsuario(id)), HttpStatus.ACCEPTED);
    }

}
