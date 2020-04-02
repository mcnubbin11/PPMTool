package com.jacobsprojects.ppmtool.services;

import com.jacobsprojects.ppmtool.domain.Project;
import com.jacobsprojects.ppmtool.exceptions.ProjectIdException;
import com.jacobsprojects.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject (Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project Id '" + project.getProjectIdentifier().toUpperCase() + "' already exists");
        }
    }

    public Project findProjectByIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if (project == null) {
            throw new ProjectIdException("Project Id '" + projectId + "' does not exist");
        }

        return project;
    }

    public Iterable<Project> findAllProjects() {
       return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier (String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if (project == null) {
            throw new ProjectIdException("Can't find project with project identifier: '" + projectId + "'");
        }

        projectRepository.delete(project);
    }
}
