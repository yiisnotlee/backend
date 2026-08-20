package com.yiisnotlee.demo.controller;

import com.yiisnotlee.demo.domain.project.Project;
import com.yiisnotlee.demo.dto.ProjectResponse;
import com.yiisnotlee.demo.repository.ProjectRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/api/projects")
    @Transactional(readOnly = true)
    public List<ProjectResponse> getProjects() {
        List<Project> projects = projectRepository.findAll();

        return projects.stream()
                .map(ProjectResponse::new)
                .collect(Collectors.toList());
    }
}
