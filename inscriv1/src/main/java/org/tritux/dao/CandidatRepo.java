package org.tritux.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tritux.entites.Candidat;

@Repository
public interface CandidatRepo extends JpaRepository<Candidat, Long> {

}
