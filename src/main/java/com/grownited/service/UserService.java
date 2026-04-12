package com.grownited.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public List<UserEntity> getAllUsers() {
		return userRepo.findAll();
	}
	
	public List<UserEntity> getAllExceptUser(Long userId) {
		return userRepo.findAllExceptUser(userId);
	}
	
	public List<UserEntity> getAllUnpaidUsersByUserIdNot(Long excludedUserId) {
		return userRepo.findUnpaidUsersByUserIdNot(excludedUserId);
	}
}
