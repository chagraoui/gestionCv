package org.tritux.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tritux.entites.Recruteur;

@Repository
public interface RecruteurRepo extends JpaRepository<Recruteur, Long> {

}
