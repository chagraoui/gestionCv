package org.tritux.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tritux.entites.Certification;

@Repository
public interface CertifRepo extends JpaRepository<Certification, Long> {

}
