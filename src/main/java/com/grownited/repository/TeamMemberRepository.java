package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.TeamMembersEntity;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMembersEntity, Integer>{

}
