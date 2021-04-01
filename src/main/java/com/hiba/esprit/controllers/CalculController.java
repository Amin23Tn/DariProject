package com.hiba.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiba.esprit.calculatriceclasses.CapaciteEmprunt;
import com.hiba.esprit.calculatriceclasses.DureeEmprunt;
import com.hiba.esprit.calculatriceclasses.Mensualite;
import com.hiba.esprit.service.CapaciteEmpruntService;
import com.hiba.esprit.service.DureeEmpruntService;
import com.hiba.esprit.service.MensualiteService;

@RestController
@RequestMapping("/calculatriceFinanciere")
public class CalculController {

	@Autowired
	private MensualiteService mensualiteService;
	@Autowired
	private DureeEmpruntService dureeEmpruntService;
	@Autowired
	private CapaciteEmpruntService capaciteEmpruntService;

	@GetMapping(path = "/resultatMensualite")
	public double calculeResultatMensualite(@RequestBody Mensualite mensualite) {
		return mensualiteService.calculResultat(mensualite);
	}

	@GetMapping(path = "/resultatCapaciteEmprunt")
	public double calculeResultatCapaciteEmprunt(@RequestBody CapaciteEmprunt capaciteEmprunt) {
		return capaciteEmpruntService.calculResultat(capaciteEmprunt);
	}

	@GetMapping(path = "/resultatDureeEmprunt")
	public double calculResultatDueeEmprunt(@RequestBody DureeEmprunt dureeEmprunt) {
		return dureeEmpruntService.calculResultat(dureeEmprunt);
	}

}
