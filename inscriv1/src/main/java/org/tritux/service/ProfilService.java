package org.tritux.service;

import java.util.Collection;

import org.tritux.entites.Profil;

public interface ProfilService {
	
	Collection<Profil> findAll();
	
	Profil findOne(Long id);
	
	Profil create(Profil p);
	
	Profil update(Profil p);
	
	void delete(Long id);

}
