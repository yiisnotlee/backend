package com.yiisnotlee.demo.domain.project;

import com.yiisnotlee.demo.domain.language.Language;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "projects_translations",
        uniqueConstraints = @UniqueConstraint(columnNames = {"project_id", "language_code"}))
@Getter
@Setter
public class ProjectTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_code", nullable = false)
    private Language language;

    private String title;
    private String subtitle;

    @Lob
    private String description;
}