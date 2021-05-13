package edu.escuelaing.service4All.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.service4All.backend.model.Suscripcion;
import edu.escuelaing.service4All.backend.repository.impl.SuscripcionRepositoryImpl;

@Service
public class SuscripcionServices {

    @Autowired
	SuscripcionRepositoryImpl suscripcionRepositoryImpl;

    public List<Suscripcion> findAllSuscripciones(){
        return suscripcionRepositoryImpl.findAllSuscripciones();
        }

    public void update(Suscripcion suscripcion) {
        int s = suscripcion.getIdvendedor();
        Suscripcion suscrip=null;
        for(Suscripcion x: suscripcionRepositoryImpl.findAllSuscripciones()){
            if(x.getIdvendedor()==s){
                suscrip=x;
            }
        }
		suscrip.setMesesvigente(suscripcion.getMesesvigente());
		suscripcionRepositoryImpl.save(suscrip);
    }

    public void saveSuscripcion(Suscripcion suscrip) {
        suscripcionRepositoryImpl.save(suscrip);
    }
    
}
