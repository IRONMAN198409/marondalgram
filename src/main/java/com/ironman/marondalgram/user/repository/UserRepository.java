package com.ironman.marondalgram.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ironman.marondalgram.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
