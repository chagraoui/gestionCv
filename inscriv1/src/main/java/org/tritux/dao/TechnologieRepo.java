package org.tritux.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tritux.entites.Technolgie;

@Repository
public interface TechnologieRepo extends JpaRepository<Technolgie, Long> {

}
