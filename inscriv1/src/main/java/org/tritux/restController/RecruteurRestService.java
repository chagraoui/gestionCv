package org.tritux.restController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tritux.dao.OffreRepo;
import org.tritux.dao.TechnologieRepo;
import org.tritux.entites.Offre;
import org.tritux.entites.Technolgie;
import org.tritux.entites.User;

@RestController
@CrossOrigin()
public class RecruteurRestService {

	@Autowired
	OffreRepo offreRepo;

	@Autowired
	TechnologieRepo technologieRepo;

	// web service pour ajouter une offre
	@RequestMapping(value = "/ajouterOffre", method = RequestMethod.POST)
	public Offre ajouterOffre(@RequestBody Offre o) {
		offreRepo.save(o);
		return o;
	}
}