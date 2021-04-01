package tn.esprit.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import tn.esprit.entities.HelpCenter;
import tn.esprit.repository.HelpCenterRepository;
import tn.esprit.service.HalpCenterService;



@Service
public class HelpCenterServiceImpl implements HalpCenterService {
	@Autowired
	private HelpCenterRepository cl;
	
	
	private static final Logger L=LogManager.getLogger(HelpCenterServiceImpl.class);
	@Override
	public void ajouterClaim(HelpCenter helpCenter) {
			cl.save(helpCenter);	
	}
	@Override
	public void deleteClaim(long idContact) {
		cl.deleteById(idContact);
		
	}
	
	@Override
	public List<HelpCenter> afficherClaim() {
		List<HelpCenter> HelpCenters =(List<HelpCenter>) cl.findAll();
		for(HelpCenter helpCenter:HelpCenters) {
			L.info("HelpCenter ++:"+helpCenter);
		}
		return HelpCenters;
	}
	
	
	
	
	}
	
		

	
	

