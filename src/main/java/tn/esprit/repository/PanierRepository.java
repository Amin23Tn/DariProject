package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Panier;
import tn.esprit.entities.Ad;
import tn.esprit.entities.User;


@Repository
public interface PanierRepository extends CrudRepository<Panier, Long> {
	
	

}
