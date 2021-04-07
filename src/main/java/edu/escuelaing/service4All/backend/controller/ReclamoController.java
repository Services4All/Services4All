package edu.escuelaing.service4All.backend.controller;


import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.service4All.backend.model.Comentario;
import edu.escuelaing.service4All.backend.model.Reclamo;
import edu.escuelaing.service4All.backend.services.ComentarioServices;
import edu.escuelaing.service4All.backend.services.ReclamoServices;


@RestController
@RequestMapping(value = "/reclamos")
public class ReclamoController {
	@Autowired
	ReclamoServices reclamoServices;
	
    @GetMapping
    public  List<Reclamo>  findAllReclamos() {
        List<Reclamo> reclamos = reclamoServices.findAllComentarios();
       return reclamos;
    }

   
}
