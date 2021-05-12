package edu.escuelaing.service4All.backend.repository;

import edu.escuelaing.service4All.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findAll();

}
