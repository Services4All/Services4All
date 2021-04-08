package edu.escuelaing.service4All.backend.controller;

import com.google.gson.Gson;
import edu.escuelaing.service4All.backend.model.Compra;
import edu.escuelaing.service4All.backend.services.CompraServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/compras")
public class CompraController {

    @Autowired
    CompraServices compraServices;

    @PostMapping(value="/nuevaCompra")
    public ResponseEntity<String> addCompra(@RequestBody Compra compra){
        try{
            compraServices.saveCompra(compra);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping()
    public ResponseEntity<String> getAllComprass(){
        try{
            return new ResponseEntity<>(new Gson().toJson(compraServices.findAllCompras()), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value="/{id}")
    public  ResponseEntity<String>  findComprasByIdServicio(@PathVariable int id) {
        try{
            return new ResponseEntity<>(new Gson().toJson(compraServices.findCompraByIdS(id)), HttpStatus.ACCEPTED);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
