package edu.escuelaing.service4All.backend.controller;

import com.google.gson.Gson;
import edu.escuelaing.service4All.backend.model.Favorito;
import edu.escuelaing.service4All.backend.services.FavoritoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/favoritos")
public class FavoritoController {

    @Autowired
    FavoritoServices favoritosServices;

    @GetMapping()
    public ResponseEntity<String> getAllFavoritos(){
        return new ResponseEntity<>(new Gson().toJson(favoritosServices.findAllFavoritos()), HttpStatus.OK);
    }

    @RequestMapping(value="/nuevoFavorito",method = RequestMethod.POST)
    public ResponseEntity<?> addFavorito(@RequestBody Favorito fav){
        try {
            favoritosServices.AddFavorito(fav);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }
    }
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public  ResponseEntity<?>  findServiciosByIdUsuario(@PathVariable int id) {
        List<Favorito> favoritos = null;
        try {
            favoritos = favoritosServices.findFavoritosByIdUsuario(id);
            return new ResponseEntity<>(favoritos, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
