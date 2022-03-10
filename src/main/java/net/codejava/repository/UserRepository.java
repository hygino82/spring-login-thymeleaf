package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
