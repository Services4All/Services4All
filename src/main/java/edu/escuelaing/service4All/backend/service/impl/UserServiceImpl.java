package edu.escuelaing.service4All.backend.service.impl;

import edu.escuelaing.service4All.backend.model.User;
import edu.escuelaing.service4All.backend.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<User> userList = new ArrayList<User>();

    @PostConstruct
    public void populateUserList(){
        User user = new User();
        user.setFirstname("Prueba");
        user.setLastname("Prueba");
        user.setEmail("prueba@mail.com");
        user.setCedula("123456789");
        user.setCategory("Medicina");
        user.setCity("Bogotá");
        /**
         * La contraseña es 12345
         */
        user.setPassword("$2y$12$YUmv2F8VQEAdeYxM3.XLAOOt30G1.yXnXYVgwd5eXaz09WHB9wz7G");
        userList.add(user);
    }

    /**
     * Valida que el usuario se encuentre registrado.
     *
     * @param user usuario a ser registrado.
     * @return En caso de encontrase, retorna el usuario.
     */
    @Override
    public User isRegister(User user) {
        User res = null;
        if(userList.contains(user)){
            res = user;
        }
        return res;
    }

    /**
     * Este es el método que implementa el registro del usuario (Esteban Bernal)
     *
     * @param user
     * @return
     */
    @Override
    public User signin(User user) {
        return null;
    }

    /**
     * En caso de encontrase, retorna el usuario según su correo.
     *
     * @param correo correo del usuario a ser retornado.
     * @return el usuario que tenga el correo.
     */
    @Override
    public User getUserByCorreo(String correo) {
        User res = null;
        for(User user: userList){
            if(user.getEmail().equals(correo)){
                res = user;
            }
        }
        return res;
    }

    @Override
    public User findUserByName(String name) {
        User res = null;
        for(User user : userList){
            if(user.getFirstname().equals(name)){
                res = user;
            }
        }
        return res;
    }


}
