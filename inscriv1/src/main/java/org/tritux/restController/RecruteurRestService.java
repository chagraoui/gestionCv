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
		offreRepo.save(o);
		return o;
	}
	
	@RequestMapping(value="/voirOffre/{id}",method=RequestMethod.GET)
	public Collection<Offre> candidatures(@PathVariable Long id) {
		return recruteurRepo.findOne(id).getRecOffres();
}
	
}