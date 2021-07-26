package com.bookstore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepo extends JpaRepository<Login, Long>{
	@Query("SELECT u FROM Login u WHERE u.email = ?1")
	public Login findByEmail(String email);
}
