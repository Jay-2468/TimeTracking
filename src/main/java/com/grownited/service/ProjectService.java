package com.grownited.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grownited.dto.ProjectDto;
import com.grownited.entity.ProjectEntity;
import com.grownited.repository.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<ProjectDto> getAllProjects() {

        List<ProjectEntity> projects = projectRepository.findAll();
        List<ProjectDto> dtoList = new ArrayList<>();

        for (ProjectEntity p : projects) {
            ProjectDto dto = new ProjectDto();
            dto.setProjectName(p.getProjectName());
            dto.setEstimatedHours(p.getEstimatedHours());
            dtoList.add(dto);
        }

        return dtoList;
    }
}