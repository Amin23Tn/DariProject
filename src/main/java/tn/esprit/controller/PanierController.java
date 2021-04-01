package tn.esprit.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Panier;
import tn.esprit.repository.PanierRepository;
import tn.esprit.service.PanierService;

@RestController
@RequestMapping("/Reportt")
public class PanierController {
	
	
	@Autowired
	private PanierService panierservice ; 
	
	@GetMapping("/afficherPanier") 
	@ResponseBody 
	 //http://localhost:8081/retrieve-all-users 
	 public List<Panier> getPanier() { 
		 List<Panier> list = panierservice.afficherPanier() ; 
		 return list; 
	} 
	
	
	@PostMapping("/ajouterPanier/{prodname}") 
	 public String addPanier(@RequestBody Panier panier,@PathVariable String prodname) {
		
		 panier.setUserId(10); 
		 panier.setProductName(prodname);
		 panierservice.ajouterPanier(panier); 
		 return ("ajouté au panier");
	} 
	
	@DeleteMapping("/deletePanier") 
	 public void deletePanier(@Param(value = "id") long id) { 
		 panierservice.deletePanier(id); 
	} 
	
	@GetMapping("/Carts/{id}")
	public Panier findByid(@PathVariable long id){
		return panierservice.findPanierwithId(id);
	}
}

