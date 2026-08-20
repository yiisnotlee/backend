package com.yiisnotlee.demo.domain.project;

import com.yiisnotlee.demo.domain.profile.Profile;
import com.yiisnotlee.demo.domain.techstack.TechStack;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "projects")
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    private String thumbnailUrl;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isOngoing;

    private String githubUrl;
    private String techblogUrl;
    private String demoUrl;
    private Integer sortOrder;
    private Boolean isPublished;

    @ElementCollection
    @CollectionTable(
            name = "project_roles",
            joinColumns = @JoinColumn(name = "project_id")
    )
    @Column(name = "role_key")
    @OrderColumn(name = "sort_order")
    private List<String> roles = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "projects_tech_stacks",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "tech_stack_id")
    )
    private Set<TechStack> techStacks = new HashSet<>();

    @OneToMany(mappedBy = "project")
    private List<ProjectTranslation> translations = new ArrayList<>();

}
