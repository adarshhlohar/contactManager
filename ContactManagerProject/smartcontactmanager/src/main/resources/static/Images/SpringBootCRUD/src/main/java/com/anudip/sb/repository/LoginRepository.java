package com.anudip.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.sb.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{
	
	public Login findByUserNameAndPassword(String userName, String Password);
}
