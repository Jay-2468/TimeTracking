package com.grownited.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.UserEntity;
import com.grownited.entity.UserEntity.Role;

@Repository // has to use this annotation for every Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> // has to extends JpaRepository for Repository 
{ 
	Optional<UserEntity> findByEmail(String email);
	
	List<UserEntity> findByRole(Role role);
}
