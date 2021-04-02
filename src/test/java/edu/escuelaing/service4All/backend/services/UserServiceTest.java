package edu.escuelaing.service4All.backend.services;

import edu.escuelaing.service4All.backend.Service4AllApplication;
import edu.escuelaing.service4All.backend.exceptions.Service4AllException;
import edu.escuelaing.service4All.backend.model.User;
import edu.escuelaing.service4All.backend.security.UserDetailsServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Service4AllApplication.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Test
    public void shouldFindUserByName() throws Service4AllException {
        User user = userService.findUserByName("Prueba");
        Assert.assertTrue(user.getId()==1000);
        Assert.assertTrue(user.getFirstname().equals("Prueba"));
        Assert.assertTrue(user.getEmail().equals("prueba@mail.com"));
        Assert.assertTrue(user.getCategory().equals("Medicina"));
        Assert.assertTrue(user.getCedula().equals("123456789"));
        Assert.assertTrue(user.getCity().equals("Bogotá"));
        Assert.assertTrue(user.getLastname().equals("Prueba"));
        Assert.assertTrue(user.getPassword().equals("$2y$12$YUmv2F8VQEAdeYxM3.XLAOOt30G1.yXnXYVgwd5eXaz09WHB9wz7G"));
    }

    @Test
    public void shouldBeRegistered() throws Service4AllException {
        User user = userService.findUserByName("Prueba");
        User userRegistered = userService.isRegister(user);
        Assert.assertTrue(userRegistered.getFirstname().equals("Prueba"));
    }

    @Test
    public void shouldFindUserByCorreo() throws Service4AllException {
        User user = userService.getUserByCorreo("prueba@mail.com");
        Assert.assertTrue(user.getFirstname().equals("Prueba"));
    }

    @Test
    public void shouldFindAllUsers() throws Service4AllException {
        List<User> users = userService.findAll();
        Assert.assertTrue(users.size()>=0);
    }

    @Test
    public void shouldCreateUser() {
        User user = new User();
        user.setId(1);
        user.setPassword("123456789");
        user.setCity("Bogotá");
        user.setCategory("Zapatos");
        user.setFirstname("Prueba");
        user.setLastname("Prueba");
        user.setCedula("1029384756");
        user.setEmail("prueba@gmail.com");
        Assert.assertTrue(user.getId()==1);
    }

    @Test
    public void shouldCreateUserWithConstructor(){
        User user = new User(1, "Prueba", "Prueba", "prueba@mail.com", "12345", "Zapatos", "Bogotá", "123456789");
        Assert.assertTrue(user.getId()==1);
    }

    @Test
    public void shouldLoadUserByUsername(){
        UserDetails userDetails = this.userDetailsService.loadUserByUsername("prueba@mail.com");
        Assert.assertTrue(userDetails.getUsername().equals("Prueba"));
    }

    @Test
    public void shouldNotLoadUserByUsername(){
        UserDetails userDetails = this.userDetailsService.loadUserByUsername("test@mail.com");
        Assert.assertTrue(userDetails.getUsername().equals("Prueba"));
    }

}
