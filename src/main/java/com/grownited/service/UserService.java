package com.grownited.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public UserEntity findById(Long userId) {
		Optional<UserEntity> opUser = userRepo.findById(userId);
		UserEntity user = null;
		if (opUser.isPresent()) {
			user = opUser.get();
		}
		return user;
	}

	public List<UserEntity> getAllUsersNotDeleted() {
		return userRepo.findByIsDeletedFalse();
	}

	public List<UserEntity> getAllExceptUser(Long userId) {
		return userRepo.findAllExceptUser(userId);
	}

	public List<UserEntity> getAllUnpaidUsersByUserIdNot(Long excludedUserId) {
		return userRepo.findUnpaidUsersByUserIdNot(excludedUserId);
	}

	public void archiveUser(Long userId) {
		Optional<UserEntity> opUser = userRepo.findById(userId);
		if (opUser.isPresent()) {
			UserEntity user = opUser.get();
			user.setIsDeleted(true);
			userRepo.save(user);
		}
	}

	public void updateUser(UserEntity updatedUser) {
		UserEntity existingUser = userRepo.findById(updatedUser.getUserId()).orElse(null);

		if (existingUser != null) {
			existingUser.setFirstName(updatedUser.getFirstName());
			existingUser.setLastName(updatedUser.getLastName());
			existingUser.setEmail(updatedUser.getEmail());
			existingUser.setContactNumber(updatedUser.getContactNumber());
			existingUser.setHourlyRate(updatedUser.getHourlyRate());

			userRepo.save(existingUser);
		}
	}

	public List<UserEntity> findAll() {
		return userRepo.findAll();
	}
}
