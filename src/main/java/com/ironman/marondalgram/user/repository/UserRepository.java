package com.ironman.marondalgram.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ironman.marondalgram.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	// SELECT count(1) ... WHERE `loginId` = #{loginId};
	public int countByLoginId(String loginId);
	
	// user테이블에 잘못 저장되어 여러개가 나올수 있으므로 List타입으로 반환
	public List<User> findByLoginIdAndPassword(String loginId, String password);
	
}
