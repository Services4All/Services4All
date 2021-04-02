package edu.escuelaing.service4All.backend.exceptions;

public class Service4AllException extends Exception{
    public static final String USUARIO_NO_EXISTE = "El usuario no fue encontrado";

    public Service4AllException(String message){
        super(message);
    }
}
