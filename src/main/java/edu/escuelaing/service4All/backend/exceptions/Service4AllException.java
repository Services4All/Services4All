package edu.escuelaing.service4All.backend.exceptions;

public class Service4AllException extends Exception{
    public static final String USUARIO_NO_EXISTE = "El usuario no fue encontrado";
    public static final String SERVICIO_NO_EXISTE = "El servicio no fue encontrado";
    public static final String SERVICIOS_NO_ASOCIADOS = "El grupo de servicios se encuentra vacío";


    public Service4AllException(String message){
        super(message);
    }
}
