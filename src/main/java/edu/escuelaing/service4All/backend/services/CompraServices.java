package edu.escuelaing.service4All.backend.services;

import edu.escuelaing.service4All.backend.model.Compra;
import edu.escuelaing.service4All.backend.repository.impl.CompraRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CompraServices {
    @Autowired
    private CompraRepositoryImpl compraRepository;

    public List<Compra> findAllCompras() {
        return compraRepository.findAllCompras();
    }
        public void saveCompra(Compra c){
            compraRepository.saveCompra(c);
        }
        public Optional<Compra> findCompraByIdS(int id) {
            return compraRepository.findComprasByIdS(id);
        }
}
