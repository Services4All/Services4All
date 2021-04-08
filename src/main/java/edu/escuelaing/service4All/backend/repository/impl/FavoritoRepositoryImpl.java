package edu.escuelaing.service4All.backend.repository.impl;

import edu.escuelaing.service4All.backend.model.Favorito;
import edu.escuelaing.service4All.backend.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoritoRepositoryImpl {

    @Autowired
    FavoritoRepository favoritoRepository;

    public void AddFavorito(Favorito fav) {
        favoritoRepository.save(fav);
    }

    public List<Favorito> findAllFavoritos() {
        return  favoritoRepository.findAll();
    }

    public List<Favorito> FindByIdUsuario(int id) {
        List<Favorito> result= new ArrayList<>();
        for (Favorito fav: favoritoRepository.findAll()) {
            if(fav.getIdusuario()==id) {
                result.add(fav);
            }
        }
        return  result;
    }

}
