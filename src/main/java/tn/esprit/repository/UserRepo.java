package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.entities.User;

public interface UserRepo extends CrudRepository<User, Long> {

}
