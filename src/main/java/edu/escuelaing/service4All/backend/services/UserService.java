package edu.escuelaing.service4all.backend.services;

import edu.escuelaing.service4all.backend.exceptions.Service4AllException;
import edu.escuelaing.service4all.backend.model.User;

import java.util.List;

public interface UserService {
    /**
     * Register a new user
     *
     * @param user
     * @return user registered
     */
    public User isRegister(User user) throws Service4AllException;

    public void saveUser(User user);

    public User getUserByCorreo(String correo) throws Service4AllException;

    public User findUserByName(String name) throws Service4AllException;

    public List<User> findAll();

}
