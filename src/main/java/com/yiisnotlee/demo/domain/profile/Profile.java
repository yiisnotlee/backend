package com.yiisnotlee.demo.domain.profile;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profile")
@Getter
@Setter
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String phone;
    private String githubUrl;
    private String techblogUrl;
    private BigDecimal gpa;
    private String profileUrl;
    private String avatarUrl;

    @OneToMany(mappedBy = "profile")
    private List<ProfileTranslation> translations = new ArrayList<>();
}
