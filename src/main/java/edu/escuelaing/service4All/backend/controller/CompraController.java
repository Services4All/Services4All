package edu.escuelaing.service4All.backend.controller;

import com.google.gson.Gson;
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

    @GetMapping()
    public ResponseEntity<String> getAllComprass(){
        return new ResponseEntity<>(new Gson().toJson(compraServices.findAllCompras()), HttpStatus.OK);

    }

    @GetMapping(value="/{id}")
    public  ResponseEntity<String>  findComprasByIdServicio(@PathVariable int id) {
        return new ResponseEntity<>(new Gson().toJson(compraServices.findCompraByIdS(id)), HttpStatus.ACCEPTED);
    }
}
