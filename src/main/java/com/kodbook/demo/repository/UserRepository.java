package com.kodbook.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodbook.demo.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>
{
	public Users findByEmail(String email);
	
	public Users findByUsername(String username);

}
