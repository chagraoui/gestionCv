package org.tritux.restController;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tritux.dao.CandidatRepo;
import org.tritux.dao.ProfilRepo;
import org.tritux.dao.UserRepo;
import org.tritux.entites.Candidat;
import org.tritux.entites.Offre;
import org.tritux.entites.Profil;
import org.tritux.entites.Technolgie;
import org.tritux.service.ProfilService;

import antlr.collections.List;

@RestController
@CrossOrigin()
public class CandidatRestService {

	@Autowired
	CandidatRepo candidatRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	ProfilService profilService;

	// retourner le user par id
	@RequestMapping(value = "/profilUser/{id}", method = RequestMethod.GET)
	public Profil profil1(@PathVariable Long id) {
		Profil p = profilService.findOne(id);
		return p;
	}

	// retourner le profil par id
	@RequestMapping(value = "/profilCand/{id}", method = RequestMethod.GET)
	public Candidat profil(@PathVariable Long id) {
		return candidatRepo.findOne(id);
	}

	//la liste des candidatres du condidat dont son id=?
	@RequestMapping(value = "/candidatures/{id}", method = RequestMethod.GET)
	public Collection<Offre> candidatures(@PathVariable Long id) {
		return candidatRepo.findOne(id).getListCandidatures();
	}
	
	
	// retourner les technologie par id profil
	@RequestMapping(value = "/profiltech/{id}", method = RequestMethod.GET)
	public Collection<Technolgie> proftech(@PathVariable Long id) {
		Profil p = profilService.findOne(id);
		return p.getTechnologies();
	}
	
	

}
