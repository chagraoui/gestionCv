package org.tritux.restController;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tritux.dao.CandidatRepo;
import org.tritux.dao.OffreRepo;
import org.tritux.dao.RecruteurRepo;
import org.tritux.dao.TechnologieRepo;
import org.tritux.entites.Candidat;
import org.tritux.entites.Offre;
import org.tritux.entites.Recruteur;
import org.tritux.entites.Technolgie;

@RestController
@CrossOrigin()
public class AdminRestService {

	@Autowired
	RecruteurRepo recruteurRepo;

	@Autowired
	TechnologieRepo technologieRepo;

	@Autowired
	OffreRepo offreRepo;

	@Autowired
	CandidatRepo candidatRepo;

	// **************************** CRUD RECRUTEUR
	

	// web service pour ajouter un recruteur
	@RequestMapping(value = "/ajouterRec", method = RequestMethod.POST)
	public Recruteur ajoutRec(@RequestBody Recruteur rec) {
		Recruteur r = rec;
		recruteurRepo.save(r);
		return recruteurRepo.findOne(r.getId());
	}

	// liste des recrutuer
	@RequestMapping(value = "/listRecruteur", method = RequestMethod.GET)
	public Collection<Recruteur> listRecruteur() {
		return recruteurRepo.findAll();
	}

	// supprimer recrutuer
	@RequestMapping(value = "/supRecruteur/{id}", method = RequestMethod.DELETE)
	public void suprimerRecruteur(@PathVariable Long id) {
		recruteurRepo.delete(id);
	}

	// **************************** CRUD Candidat
	

	// web service pour ajouter un Candidat
	@RequestMapping(value = "/ajouterCandidat", method = RequestMethod.POST)
	public Candidat ajoutCandidat(@RequestBody Candidat cand) {
		candidatRepo.save(cand);
		return candidatRepo.findOne(cand.getId());
	}

	// liste des Candidat
	@RequestMapping(value = "/listCandidat", method = RequestMethod.GET)
	public Collection<Candidat> listCandidat() {
		return candidatRepo.findAll();
	}

	// supprimer Candidat
	@RequestMapping(value = "/supCandidat/{id}", method = RequestMethod.DELETE)
	public void suprimerCandidat(@PathVariable Long id) {
		candidatRepo.delete(id);
	}

	// ****************************************
	

	// liste des offres publié
	@RequestMapping(value = "/listOffre", method = RequestMethod.GET)
	public Collection<Offre> listOffre() {
		return offreRepo.findAll();
	}

	// web service pour retrouner la list des technologies
	@RequestMapping(value = "/listechno", method = RequestMethod.GET)
	public Collection<Technolgie> listTechnologie() {
		return technologieRepo.findAll();
	}

}
