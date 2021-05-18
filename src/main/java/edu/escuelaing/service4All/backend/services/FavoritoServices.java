package edu.escuelaing.service4All.backend.services;

import edu.escuelaing.service4All.backend.model.Favorito;
import edu.escuelaing.service4All.backend.repository.impl.FavoritoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FavoritoServices {

    @Autowired
    private FavoritoRepositoryImpl favorito;

    public void addfavorito(Favorito fav) {
        favorito.addfavorito(fav);
    }

    public List<Favorito> findAllFavoritos(){
        return favorito.findAllFavoritos();
    }

    public Optional<Favorito> findFavoritosByIdUsuario(int id) {
        return favorito.findAllFavoritosById(id);
    }

    public void removeFavorito(Favorito fav){favorito.removeFavorito(fav);}
}
