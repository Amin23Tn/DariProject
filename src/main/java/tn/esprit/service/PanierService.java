package tn.esprit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.entities.Ad;
import tn.esprit.entities.Panier;
import tn.esprit.entities.User;

public interface PanierService {
	

	List<Panier> afficherPanier();

	void deletePanier(long idPanier);

	Panier findPanierwithId(long id);

	List<User> getAllUsers();

	int getUserByName(String name);

	void ajouterPanier(Panier panier);
	

}
