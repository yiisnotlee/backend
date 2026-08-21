package com.yiisnotlee.demo.dto;

import com.yiisnotlee.demo.domain.profile.Profile;
import lombok.Getter;

import java.math.BigDecimal; // 🌟 BigDecimal 임포트 추가됨!
import java.util.Arrays;
import java.util.List;

@Getter
public class ProfileResponse {
    private Long id;
    private String email;
    private String phone;
    private String githubUrl;
    private String techblogUrl;
    private BigDecimal gpa;
    private String avatarUrl;

    private String name;
    private String headline;
    private String schoolName;
    private String major;
    private String address;
    private String description;
    private String introduction;
    private List<String> tags;

    public ProfileResponse(Profile profile, String langCode) {
        this.id = profile.getId();
        this.email = profile.getEmail();
        this.phone = profile.getPhone();
        this.githubUrl = profile.getGithubUrl();
        this.techblogUrl = profile.getTechblogUrl();
        this.gpa = profile.getGpa();
        this.avatarUrl = profile.getAvatarUrl();

        if (profile.getTranslations() != null) {
            profile.getTranslations().stream()
                    .filter(t -> langCode.equals(t.getLanguage().getCode()))
                    .findFirst()
                    .ifPresent(translation -> {
                        this.name = translation.getName();
                        this.headline = translation.getHeadline();
                        this.schoolName = translation.getSchoolName();
                        this.major = translation.getMajor();
                        this.address = translation.getAddress();
                        this.description = translation.getDescription();
                        this.introduction = translation.getIntroduction();
                        if (translation.getTags() != null) {
                            this.tags = Arrays.asList(translation.getTags().split(","));
                        }
                    });
        }
    }
}