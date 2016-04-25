package org.tritux.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tritux.entites.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	public User findBylogin(String l);

}
