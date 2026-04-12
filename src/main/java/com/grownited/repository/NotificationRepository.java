package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.NotificationEntity;
import com.grownited.entity.UserEntity;

import java.util.List;


@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long>{

	List<NotificationEntity> findBySentTo(UserEntity sentTo);
}
