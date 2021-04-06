package edu.escuelaing.service4All.backend.services;

import java.util.List;

import edu.escuelaing.service4All.backend.exceptions.Service4AllException;
import edu.escuelaing.service4All.backend.model.User;

public interface UserService {

    public User isRegister(User user) throws Service4AllException;


    public User getUserByCorreo(String correo) throws Service4AllException;

    public User findUserByName(String name) throws Service4AllException;

    public List<User> findAll();

}
