package org.tritux.restController;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tritux.entites.Offre;
import org.tritux.entites.Recruteur;
import org.tritux.entites.Technolgie;
import org.tritux.repository.OffreRepo;
import org.tritux.repository.RecruteurRepo;
import org.tritux.repository.TechnologieRepo;

@RestController
@CrossOrigin()
public class AdminRestService {

	@Autowired
	RecruteurRepo recruteurRepo;
	
	@Autowired
	TechnologieRepo technologieRepo;
	

	@Autowired
	OffreRepo offreRepo;
	
	
	//web service pour ajouter un recruteur
	@RequestMapping(value = "/ajouterRec", method = RequestMethod.POST)
	public Recruteur ajoutRec(@RequestBody Recruteur rec) {
		Recruteur r=rec;
		recruteurRepo.save(r);
		return recruteurRepo.findOne(r.getId());
	}
	
	//web service pour ajouter un recruteur
	@RequestMapping(value = "/listechno", method = RequestMethod.GET)
	public Collection<Technolgie> listTechnologie() {
	
		return technologieRepo.findAll();
	}
	
	//liste des recrutuer
	@RequestMapping(value = "/listRecruteur", method = RequestMethod.GET)
	public Collection<Recruteur> listRecruteur() {
	
		return recruteurRepo.findAll();
	}
	
	
	//liste des offres publié 
	@RequestMapping(value = "/listOffre", method = RequestMethod.GET)
	public  Collection<Offre> listOffre() {
		
		return offreRepo.findAll();
	}
	
	
	
}
