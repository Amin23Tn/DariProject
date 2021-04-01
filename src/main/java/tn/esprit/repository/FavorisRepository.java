package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.Customer;
import tn.esprit.entities.Favoris;

import java.util.List;

@Repository
public interface FavorisRepository extends CrudRepository<Favoris, Long> {
    List<Favoris> findAllByCustomer(Customer customer);

}
