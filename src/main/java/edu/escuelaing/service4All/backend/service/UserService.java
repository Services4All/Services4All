package edu.escuelaing.service4All.backend.service;

import edu.escuelaing.service4All.backend.model.User;

public interface UserService {
    /**
     * Register a new user
     *
     * @param user
     * @return user registered
     */
    public User isRegister(User user);

    public User signin(User user);

    public User getUserByCorreo(String correo);

    public User findUserByName(String name);
}
