package org.tritux.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tritux.entites.Diplomes;

@Repository
public interface DiplomesRepo extends JpaRepository<Diplomes, Long> {

}
