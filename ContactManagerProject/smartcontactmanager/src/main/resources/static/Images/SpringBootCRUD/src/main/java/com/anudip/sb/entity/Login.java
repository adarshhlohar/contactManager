package com.anudip.sb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Login {
	
	@Id
	private int uid;
	
	@Column(length=8, nullable = false)
	private String userName;
	
	@Column(length=10, nullable = false)
	private String password;
	
	
}
