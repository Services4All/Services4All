package edu.escuelaing.service4All.backend.services.impl;

import edu.escuelaing.service4All.backend.exceptions.Service4AllException;
import edu.escuelaing.service4All.backend.model.User;
import edu.escuelaing.service4All.backend.repository.UserRepository;
import edu.escuelaing.service4All.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    List<User> userList = new ArrayList<>();


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
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        /*modificar el password para que sea seguro*/
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
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

    @Override
    public List<User> getUserForType(String tipousuario) {
        List<User> listaUsersForType =new ArrayList<>();

        for(User user : userRepository.findAll()){
            if(user.getTipo().equals(tipousuario)){
                listaUsersForType.add(user);
            }
        }
        return userRepository.findAll();
    }

    @Override
    public void deleUser(int id) {
        userRepository.deleteById(id);
    }



}
