package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.Customer;
import tn.esprit.entities.Rating;

import java.util.List;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
    List<Rating> findAllByUsertorate(Customer customer);
}
