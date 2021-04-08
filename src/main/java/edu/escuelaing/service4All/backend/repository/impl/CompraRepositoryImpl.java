package edu.escuelaing.service4All.backend.repository.impl;

import edu.escuelaing.service4All.backend.model.Compra;
import edu.escuelaing.service4All.backend.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompraRepositoryImpl {

    @Autowired
    CompraRepository compraRepository;

    public List<Compra> findAllCompras() {
        return  compraRepository.findAll();
    }
    public void saveCompra(Compra compra) {
        compraRepository.save(compra);
    }
    public Optional<Compra> findComprasByIdS(int id) {
        List<Compra> res= new ArrayList<>();
        for (Compra c: compraRepository.findAll()) {
            if(c.getIdservicio()==id) {
                res.add(c);
            }
        }
        return res.stream().findAny();
    }
}
