package edu.escuelaing.service4All.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.escuelaing.service4All.backend.model.User;
import edu.escuelaing.service4All.backend.model.User;

import java.util.List;

//@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findAll();

}
