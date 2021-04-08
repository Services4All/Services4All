package edu.escuelaing.service4All.backend.repository.impl;

import edu.escuelaing.service4All.backend.model.Favorito;
import edu.escuelaing.service4All.backend.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FavoritoRepositoryImpl {

    @Autowired
    FavoritoRepository favoritoRepository;

    public List<Favorito> findAllFavoritos() {
        return  favoritoRepository.findAll();
    }

}
