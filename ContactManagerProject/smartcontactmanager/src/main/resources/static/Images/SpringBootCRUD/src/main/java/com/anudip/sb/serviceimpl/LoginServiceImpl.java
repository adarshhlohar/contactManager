package com.anudip.sb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.sb.entity.Login;
import com.anudip.sb.repository.LoginRepository;
import com.anudip.sb.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginRepository lrepo;

	@Override
	public Login loginUser(String userName, String password) {
		Login login = lrepo.findByUserNameAndPassword(userName, password);
		return login;
	}


}
