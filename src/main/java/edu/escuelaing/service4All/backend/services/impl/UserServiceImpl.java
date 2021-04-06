package edu.escuelaing.service4All.backend.services.impl;

import edu.escuelaing.service4All.backend.exceptions.Service4AllException;
import edu.escuelaing.service4All.backend.model.User;
import edu.escuelaing.service4All.backend.repository.UserRepository;
import edu.escuelaing.service4All.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    List<User> userList = new ArrayList<User>();

    //@PostConstruct
    //public void populateUserList(){
    //    User user = new User();
    //    user.setId(1000);
    //    user.setFirstname("Prueba");
    //    user.setLastname("Prueba");
    //    user.setEmail("prueba@mail.com");
    //    user.setCedula("123456789");
    //    user.setCategory("Medicina");
    //    user.setCity("Bogotá");
    //    /**
    //     * La contraseña es 12345
    //     */
    //    user.setPassword("$2y$12$YUmv2F8VQEAdeYxM3.XLAOOt30G1.yXnXYVgwd5eXaz09WHB9wz7G");
    //    userList.add(user);
    //}


    /**
     * Valida que el usuario se encuentre registrado.
     *
     * @param user usuario a ser registrado.
     * @return En caso de encontrase, retorna el usuario.
     */
    @Override
    public User isRegister(User user) throws Service4AllException {
        User res = null;
        for(User us: userRepository.findAll()){
            if(us.getId()==user.getId()){
                res = user;
            }
        }
        if(res == null) throw new Service4AllException(Service4AllException.USUARIO_NO_EXISTE);
        return res;
    }

    /**
     * Este es el método que implementa el registro del usuario
     *
     * @param user
     * @return
     */
    @Override
    public void saveUser(User user) {
       
    }

    /**
     * En caso de encontrase, retorna el usuario según su correo.
     *
     * @param correo correo del usuario a ser retornado.
     * @return el usuario que tenga el correo.
     */
    @Override
    public User getUserByCorreo(String correo) throws Service4AllException {
        User res = null;
        for(User user: userRepository.findAll()){
            if(user.getEmail().equals(correo)){
                res = user;
            }
        }
        if(res == null) throw new Service4AllException(Service4AllException.USUARIO_NO_EXISTE);
        return res;
    }

    @Override
    public User findUserByName(String name) throws Service4AllException {
        User res = null;
        for(User user : userRepository.findAll()){
            if(user.getFirstname().equals(name)){
                res = user;
            }
        }
        if(res == null) throw new Service4AllException(Service4AllException.USUARIO_NO_EXISTE);
        return res;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }



}
