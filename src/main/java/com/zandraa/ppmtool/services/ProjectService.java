package com.zandraa.ppmtool.services;

import com.zandraa.ppmtool.domain.Project;
import com.zandraa.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project savveOrUpdate(Project project) {
        return projectRepository.save(project);
    }
}