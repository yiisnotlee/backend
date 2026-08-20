package com.yiisnotlee.demo.dto;

import com.yiisnotlee.demo.domain.profile.Profile;
import lombok.Getter;

import java.math.BigDecimal; // 🌟 BigDecimal 임포트 추가됨!

@Getter
public class ProfileResponse {
    private Long id;
    private String email;
    private String phone;
    private String githubUrl;
    private String techblogUrl;
    private BigDecimal gpa; // 🌟 Double에서 BigDecimal로 수정됨!
    private String avatarUrl;

    // 다국어(번역) 필드들
    private String name;
    private String headline;
    private String schoolName;
    private String major;
    private String address;

    // 🌟 생성자에서 langCode를 받도록 수정됨
    public ProfileResponse(Profile profile, String langCode) {
        this.id = profile.getId();
        this.email = profile.getEmail();
        this.phone = profile.getPhone();
        this.githubUrl = profile.getGithubUrl();
        this.techblogUrl = profile.getTechblogUrl();
        this.gpa = profile.getGpa();
        this.avatarUrl = profile.getAvatarUrl();

        // 🌟 "ko" 하드코딩 대신 밖에서 받은 langCode로 번역본 찾기
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
                    });
        }
    }
}