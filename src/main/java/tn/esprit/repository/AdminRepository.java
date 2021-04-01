package tn.esprit.repository;

import tn.esprit.entities.Administrator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends CrudRepository<Administrator, Long> {
    List<Administrator> findAll();
}
