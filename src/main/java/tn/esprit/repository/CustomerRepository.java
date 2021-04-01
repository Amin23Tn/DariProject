package tn.esprit.repository;

import tn.esprit.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findAll();
    Customer findCustomerByIdUser(long idUser);
}