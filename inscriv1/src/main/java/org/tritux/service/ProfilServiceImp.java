package org.tritux.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tritux.dao.ProfilRepo;
import org.tritux.entites.Profil;

@Service
public class ProfilServiceImp implements ProfilService {

	@Autowired
	ProfilRepo profilRepo;

	@Override
	public Collection<Profil> findAll() {
		Collection<Profil> profils = profilRepo.findAll();
		return profils;
	}

	@Override
	public Profil findOne(Long id) {
		Profil profil = profilRepo.findOne(id);
		return profil;
	}

	@Override
	public Profil create(Profil p) {
		if (p.getIdCv() != null) {
			// cannot create profil with this ID
			return null;
		}
		Profil saveProfil = profilRepo.save(p);
		return saveProfil;
	}
	@Override
	public Profil update(Profil p) {
		Profil profilperssited = findOne(p.getIdCv());
		if (profilperssited == null) {
			// cannot update profil how dont exist
			return null;
		}
		Profil profilUpdate = profilRepo.save(p);
		return profilUpdate;
	}

	@Override
	public void delete(Long id) {
		profilRepo.delete(id);
	}

}
