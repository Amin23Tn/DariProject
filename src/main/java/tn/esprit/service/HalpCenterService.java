package tn.esprit.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.entities.HelpCenter;

public interface HalpCenterService  {

	void ajouterClaim(HelpCenter helpCenter);

	List<HelpCenter> afficherClaim();

	void deleteClaim(long HelpCenter);
	
	
	
	

}
