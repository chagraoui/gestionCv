package org.tritux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tritux.entites.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

}
