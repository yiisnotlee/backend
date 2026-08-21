package com.yiisnotlee.demo.dto;

import com.yiisnotlee.demo.domain.project.Project;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProjectResponse {
    private Long id;
    private String githubUrl;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<String> roles;
    private List<String> techStacks;

    private String title;
    private String subtitle;
    private String description;

    public ProjectResponse(Project project, String langCode) {
        this.id = project.getId();
        this.githubUrl = project.getGithubUrl();
        this.roles = project.getRoles();
        this.startDate = project.getStartDate();
        this.endDate = project.getEndDate();

        this.techStacks = project.getTechStacks().stream()
                .map(tech -> tech.getName())
                .collect(Collectors.toList());

        project.getTranslations().stream()
                .filter(t -> t.getLanguage().getCode().equals(langCode))
                .findFirst()
                .ifPresent(koTranslation -> {
                    this.title = koTranslation.getTitle();
                    this.subtitle = koTranslation.getSubtitle();
                    this.description = koTranslation.getDescription();
                });
    }
}
