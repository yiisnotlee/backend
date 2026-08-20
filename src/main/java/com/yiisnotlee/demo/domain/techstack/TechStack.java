package com.yiisnotlee.demo.domain.techstack;

import com.yiisnotlee.demo.domain.profile.Profile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tech_stacks")
@Getter
@Setter
public class TechStack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    private String category;
    private String name;
    private String iconUrl;
    private Integer sortOrder;
}