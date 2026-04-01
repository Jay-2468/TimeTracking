package com.grownited.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.ForgotPasswordEntity;
import com.grownited.entity.UserEntity;


@Repository
public interface ForgotPasswordRepository extends JpaRepository<ForgotPasswordEntity, Integer> {

	Optional<ForgotPasswordEntity> findTopByUserAndUsedStatusFalseOrderByRequestTimeDesc(UserEntity userId);
}
