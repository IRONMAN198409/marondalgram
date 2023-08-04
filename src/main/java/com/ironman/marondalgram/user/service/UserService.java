package com.ironman.marondalgram.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ironman.marondalgram.common.EncryptUtils;
import com.ironman.marondalgram.user.domain.User;
import com.ironman.marondalgram.user.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User addUser(
			String loginId	
			, String password	
			, String name
			, String email) {
		
		// password 암호화
	    String encryptPassword = EncryptUtils.md5(password);

		User user = userRepository.save(User.builder()
				.loginId(loginId) 
				.password(encryptPassword)
				.email(email)
				.name(name)
				.build());

		user = userRepository.save(user);
		return user;
		
	}
	
}
