package org.tritux.restController;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tritux.entites.Candidat;
import org.tritux.entites.Profil;
import org.tritux.entites.Technolgie;
import org.tritux.repository.CandidatRepo;
import org.tritux.repository.ProfilRepo;
import org.tritux.repository.UserRepo;
import org.tritux.service.ProfilService;

@RestController
@CrossOrigin()
public class CandidatRestService {

	@Autowired
	CandidatRepo candidatRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	ProfilService profilService;

	// retourner le profil par id
	@RequestMapping(value = "/profilUser/{id}", method = RequestMethod.GET)
	public Profil profil1(@PathVariable Long id) {
		Profil p = profilService.findOne(id);
		return p;
	}

	// retourner le User par id
	@RequestMapping(value = "/profilCand/{id}", method = RequestMethod.GET)
	public Candidat profil(@PathVariable Long id) {
		return candidatRepo.findOne(id);
	}

	// retourner les technologie par id profil
	@RequestMapping(value = "/protech/{id}", method = RequestMethod.GET)
	public Collection<Technolgie> proftech(@PathVariable Long id) {
		Profil p = profilService.findOne(id);
		return p.getTechnologies();
	}

}
