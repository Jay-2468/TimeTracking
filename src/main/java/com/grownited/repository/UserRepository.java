package com.grownited.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grownited.entity.UserEntity;
import com.grownited.entity.UserEntity.Role;

@Repository // has to use this annotation for every Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> // has to extends JpaRepository for Repository
{
	Optional<UserEntity> findByEmail(String email);

	List<UserEntity> findByRole(Role role);

	@Query(value = """
			    SELECT * FROM users u
			    WHERE NOT EXISTS (
			        SELECT * FROM project_members pms
			        WHERE pms.user_id = u.user_id
			        AND pms.project_id = :projectId
			    )
			    AND u.role NOT IN (:roles)
			""", nativeQuery = true)
	List<UserEntity> findAvailableUsers(@Param("projectId") Long projectId, @Param("roles") List<String> roles);
}
