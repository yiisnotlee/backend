package com.yiisnotlee.demo.domain.project;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "projects")
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String thumbnailUrl;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isOngoing;

    private String githubUrl;
    private String techblogUrl;
    private String demoUrl;
    private Integer sortOrder;
    private Boolean isPublished;
}
