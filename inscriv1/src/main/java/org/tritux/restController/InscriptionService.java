package org.tritux.restController;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tritux.dao.CertifRepo;
import org.tritux.dao.DiplomesRepo;
import org.tritux.dao.ExperienceRepo;
import org.tritux.dao.ProfilRepo;
import org.tritux.dao.TechnologieRepo;
import org.tritux.dao.UserRepo;
import org.tritux.entites.*;
import org.tritux.service.ProfilService;

@CrossOrigin
@RestController
public class InscriptionService {
	
	@Autowired
	ProfilService profilService;

	@Autowired
	UserRepo userRepo;

	@Autowired
	ExperienceRepo experienceRepo;

	@Autowired
	DiplomesRepo diplomeRepo;

	@Autowired
	CertifRepo certifRepo;

	@Autowired
	TechnologieRepo technologieRepo;

	@RequestMapping(value = "/inscri", method = RequestMethod.POST)
	public Long Inscri(@RequestBody Inscription in) {
		System.out.println(in.getTechnologies());
		// Profil p = new Profil(in.getNom(), in.getPrenom(), in.getEmail(),
		// in.getAge(), in.getAdresse(), in.getTel(), in.getSexe(),
		// in.getExperiences(), in.getDiplomes(), in.getCertifications(),
		// in.getTechnologies());

		Profil p = new Profil(in.getNom(), in.getPrenom(), in.getEmail(),
				in.getAge(), in.getAdresse(), in.getTel(), in.getSexe(), null,
				null, null, in.getTechnologies());

		Candidat c = new Candidat(in.getLogin(), in.getPassword(),
				in.getRole(), p);

		profilService.create(p);

		// **************************** mapping profil/exerience
		// ***************************
		Collection<Exeprience> colExpereince = new ArrayList<Exeprience>();
		colExpereince = in.getExperiences();

		for (Exeprience elem : colExpereince) {
			Exeprience e = new Exeprience(elem.getNbrAnsExp(),
					elem.getDomaine(), p);
			experienceRepo.save(e);
		}
		// **************************** mapping profil/diplomes
		// ***************************
		Collection<Diplomes> colDiplomes = new ArrayList<Diplomes>();
		colDiplomes = in.getDiplomes();

		for (Diplomes elem : colDiplomes) {
			Diplomes d = new Diplomes(elem.getNom(), elem.getDateObtention(), p);
			diplomeRepo.save(d);
		}
		// **************************** mapping profil/Certifications
		Collection<Certification> certification = new ArrayList<Certification>();
		certification = in.getCertifications();

		for (Certification elem : certification) {
			Certification certif = new Certification(elem.getNomCertif(), p);
			certifRepo.save(certif);
		}
		// **************************** mapping
		// profil/technolgies************************************
		System.out.println(in.getTechnologies());
		Collection<Technolgie> techno = new ArrayList<Technolgie>();
		techno = in.getTechnologies();
		for (Technolgie elem : techno) {
			System.out.println(elem);
			Technolgie tech = new Technolgie(elem.getNomTechno());
			elem.getProfils().add(p);
			technologieRepo.save(tech);
		}
		// *************************************************************************
		profilService.update(p);
		userRepo.save(c);
		return(p.getIdCv());
	}

}
