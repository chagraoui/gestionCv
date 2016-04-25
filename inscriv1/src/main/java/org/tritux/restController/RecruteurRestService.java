package org.tritux.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tritux.entites.Offre;
import org.tritux.entites.User;
import org.tritux.repository.OffreRepo;


@RestController
@CrossOrigin()
public class RecruteurRestService {
	
	@Autowired
	OffreRepo offreRepo;
	
	//web service pour ajouter une offre
	@RequestMapping(value = "/ajouterOffre", method = RequestMethod.POST)
	public  Object ajouterOffre(@RequestBody Offre o) {
		offreRepo.save(o);
		return o;
	}
	
	


	

}
