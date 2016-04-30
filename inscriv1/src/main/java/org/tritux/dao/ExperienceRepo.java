package org.tritux.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tritux.entites.Exeprience;

@Repository
public interface ExperienceRepo extends JpaRepository<Exeprience, Long> {

}
