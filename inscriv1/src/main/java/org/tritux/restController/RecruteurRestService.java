package org.tritux.restController;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tritux.dao.OffreRepo;
import org.tritux.dao.RecruteurRepo;
import org.tritux.dao.TechnologieRepo;
import org.tritux.entites.Candidat;
import org.tritux.entites.Offre;

@RestController
@CrossOrigin()
public class RecruteurRestService {

	@Autowired
	OffreRepo offreRepo;

	@Autowired
	TechnologieRepo technologieRepo;

	@Autowired
	RecruteurRepo recruteurRepo;

	// web service pour ajouter une offre
	@RequestMapping(value = "/ajouterOffre", method = RequestMethod.POST)
	public Offre ajouterOffre(@RequestBody Offre o) {
		Offre of = new Offre();
		of.setTitreOffre(o.getTitreOffre());
		of.setDescOffre(o.getDescOffre());
		of.setDeposeur(o.getDeposeur());
		of.setListCandidatureOffre(o.getListCandidatureOffre());
		of.setTechnologiesOffre(o.getTechnologiesOffre());

		offreRepo.save(o);
		return o;
	}

	// web service pour consulter les offres du recruteur ayant le id=id
	@RequestMapping(value = "/voirOffre/{id}", method = RequestMethod.GET)
	public Collection<Offre> candidatures(@PathVariable Long id) {

		return recruteurRepo.findOne(id).getRecOffres();
	}

	// web service pour consulter les postulant a une offre ayant le id=id
	@RequestMapping(value = "/postulantOffre/{id}", method = RequestMethod.GET)
	public Collection<Candidat> postulant(@PathVariable Long id) {
		return offreRepo.findOne(id).getListCandidatureOffre();
	}
	
	// supprimer offre
	@RequestMapping(value = "/supOffre/{id}", method = RequestMethod.DELETE)
	public void suprimerRecruteur(@PathVariable Long id) {
		offreRepo.delete(id);
	}


}