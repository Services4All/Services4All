package edu.escuelaing.service4All.backend.services;

import edu.escuelaing.service4All.backend.model.Favorito;
import edu.escuelaing.service4All.backend.repository.impl.FavoritoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FavoritoServices {

    @Autowired
    private FavoritoRepositoryImpl favorito;

    public List<Favorito> findAllFavoritos(){
        return favorito.findAllFavoritos();
    }

    public List<Favorito> findFavoritosByIdUsuario(int id) {
        return favorito.FindByIdUsuario(id);
    }
}
