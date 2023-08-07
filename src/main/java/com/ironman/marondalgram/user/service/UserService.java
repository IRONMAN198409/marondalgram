package com.ironman.marondalgram.user.service;

import java.util.List;

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
	
	public boolean isDuplicateId(String loginId) {
		int count = userRepository.countByLoginId(loginId);
//		if(count == 0) {
//			// 중복 안됨
//			return false;
//		} else {
//			// 중복됨
//			return true;
//		}
		
		return count != 0;
	}
	
	public User getUser(String loginId, String password) {
		String encryptPassword = EncryptUtils.md5(password);
		
		List<User> userList = userRepository.findByLoginIdAndPassword(loginId, encryptPassword);
		if(userList.isEmpty()) {
			return null;
		} else {
			return userList.get(0);
		}
	}

	
}
