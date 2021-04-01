package tn.esprit.service;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Ad;
import tn.esprit.entities.Panier;
import tn.esprit.entities.User;
import tn.esprit.repository.PanierRepository;
import tn.esprit.repository.UserRepo;
import tn.esprit.service.PanierService;

@Service
public class PanierServiceImpl implements PanierService {
	
	@Autowired
	private PanierRepository pan;
	@Autowired
	private UserRepo userRepo ; 
	
	
	
	@Override
	public void ajouterPanier(Panier panier) {
			pan.save(panier);	
	}
	@Override
	public void deletePanier(long idPanier) {
		pan.deleteById(idPanier);
		
	}
	
	@Override
	public List<Panier> afficherPanier() {
		List<Panier> Paniers =(List<Panier>) pan.findAll();
		return Paniers;
	}
	
	@Override
	public Panier findPanierwithId(long id) {
		 Panier p = pan.findById(id).orElse(null);
		 return p;
			}
	
	@Override
	public List<User> getAllUsers(){
		return (List<User>) userRepo.findAll(); 
	}
	
	@Override
	public int getUserByName(String name){
		List<User> users = getAllUsers();
		int userId = 0 ; 
		for (User user:users){
			if (user.getNameUser().equals(name)){
				userId=user.getIdUser(); 
			}
		}
		return userId ; 
	}


}
