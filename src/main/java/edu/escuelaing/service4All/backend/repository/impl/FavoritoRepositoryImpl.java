package edu.escuelaing.service4All.backend.repository.impl;

import edu.escuelaing.service4All.backend.model.Favorito;
import edu.escuelaing.service4All.backend.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FavoritoRepositoryImpl {

    @Autowired
    FavoritoRepository favoritoRepository;

    public void addfavorito(Favorito fav) {
        favoritoRepository.save(fav);
    }

    public List<Favorito> findAllFavoritos() {
        return  favoritoRepository.findAll();
    }

    public Optional<Favorito> findAllFavoritosById(int id) {
        List<Favorito> res= new ArrayList<>();
        for (Favorito c: favoritoRepository.findAll()) {
            if(c.getIdservicio()==id) {
                res.add(c);
            }
        }
        return res.stream().findAny();
    }

    public void removeFavorito(Favorito fav) {favoritoRepository.delete(fav);}
}
