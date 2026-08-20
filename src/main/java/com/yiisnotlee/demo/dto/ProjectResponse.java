package com.yiisnotlee.demo.dto;

import com.yiisnotlee.demo.domain.project.Project;
import lombok.Getter;

import java.util.List;

@Getter
public class ProjectResponse {
    private Long id;
    private String githubUrl;
    private List<String> roles;

    private String title;
    private String subtitle;
    private String description;

    public ProjectResponse(Project project, String langCode) {
        this.id = project.getId();
        this.githubUrl = project.getGithubUrl();
        this.roles = project.getRoles();

        project.getTranslations().stream()
                .filter(t -> t.getLanguage().getCode().equals("ko"))
                .findFirst()
                .ifPresent(koTranslation -> {
                    this.title = koTranslation.getTitle();
                    this.subtitle = koTranslation.getSubtitle();
                    this.description = koTranslation.getDescription();
                });
    }
}
