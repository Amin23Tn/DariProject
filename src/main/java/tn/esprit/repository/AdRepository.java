package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.Ad;
import tn.esprit.entities.User;

import java.util.List;

@Repository
public interface AdRepository extends CrudRepository<Ad, Long> {
    List<Ad> findAllByUser(User user);

    List<Ad> findAllByNbBathroomGreaterThanOrNbGarageGreaterThanOrNbRoomGreaterThanOrPriceLessThan
            (long nbBathroom,  long nbGarage, long nbroom, float price);

}
