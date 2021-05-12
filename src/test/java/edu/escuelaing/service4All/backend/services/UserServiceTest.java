package edu.escuelaing.service4All.backend.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import edu.escuelaing.service4All.backend.services.impl.*;
import edu.escuelaing.service4All.backend.Service4AllApplication;
import edu.escuelaing.service4All.backend.exceptions.Service4AllException;
import edu.escuelaing.service4All.backend.model.User;
import edu.escuelaing.service4All.backend.security.UserDetailsServiceImpl;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Service4AllApplication.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Autowired
    UserServiceImpl userRepository;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Test
    public void shouldFindUserByName() throws Service4AllException {
        userRepository.getUserForType("comprador");
        User user = userService.findUserByName("Prueba");
        Assert.assertTrue(user.getFirstname().equals("Prueba"));
        Assert.assertTrue(user.getEmail().equals("prueba@mail.com"));
    }
    @Test
    void shouldBeRegistered() throws Service4AllException {
        User user = userService.findUserByName("Prueba");
        User userRegistered = userService.isRegister(user);
        String a = userRegistered.getFirstname();
        String b = "Prueba";
        Assert.assertEquals(a,b);
    }

    @Test
    void shouldFindUserByCorreo() throws Service4AllException {
        User user = userService.getUserByCorreo("prueba@mail.com");
        String a = user.getFirstname();
        String b = "Prueba";
        Assert.assertEquals(a,b);
    }

    @Test
    void shouldFindAllUsers() throws Service4AllException {
        List<User> users = userService.findAll();
        userService.getUserForType("comprador");
        Assert.assertTrue(users.size()>=0);
    }

    @Test
    void shouldsave() throws Service4AllException {
        userService.saveUser(userService.getUserByCorreo("prueba@mail.com"));
        List<User> users = userService.findAll();
        Assert.assertTrue(users.size()>=0);
    }

    @Test
    void shouldCreateUser() {
        User user = new User();
        user.setId(1);
        user.setPassword("123456789");
        user.setCity("Bogotá");
        user.setTipo("vendedor");
        user.setFirstname("Prueba");
        user.setLastname("Prueba");
        user.setCedula("1029384756");
        user.setEmail("prueba@gmail.com");
        Assert.assertTrue(true);
    }

    @Test
    void shouldCreateUserWithConstructor(){
        User user = new User(1, "Prueba", "Prueba", "prueba@mail.com", "12345", "Zapatos", "Bogotá", "123456789");
        Assert.assertTrue(true);
    }

    @Test
    void shouldLoadUserByUsername(){
        UserDetails userDetails = this.userDetailsService.loadUserByUsername("prueba@mail.com");
        String a = userDetails.getUsername();
        String b = "Prueba";
        Assert.assertEquals(a,b);
    }


}
