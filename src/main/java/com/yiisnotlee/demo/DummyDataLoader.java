package com.yiisnotlee.demo;

import com.yiisnotlee.demo.domain.language.Language;
import com.yiisnotlee.demo.domain.profile.Profile;
import com.yiisnotlee.demo.domain.project.Project;
import com.yiisnotlee.demo.domain.project.ProjectTranslation;
import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//@Component
public class DummyDataLoader implements CommandLineRunner {

    private final EntityManager em;

    public DummyDataLoader(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception{
        // 1. 기본 언어(한국어) 데이터 넣기
        Language ko = new Language();
        // 참고: Language 엔티티의 필드명에 맞게 세팅 (예: code, name, isActive 등)
        ko.setCode("ko");
        ko.setName("한국어");
        ko.setActive(true);
        ko.setSortOrder(1);
        em.persist(ko);

        // 2. 프로필 데이터 넣기
        Profile profile = new Profile();
        profile.setEmail("yoonseo@example.com");
        profile.setGithubUrl("https://github.com/yiisnotlee");
        em.persist(profile);

        // 3. 프로젝트 데이터 넣기
        Project project1 = new Project();
        project1.setProfile(profile);
        project1.setGithubUrl("https://github.com/yiisnotlee/sonbit");
        project1.setIsPublished(true);
        project1.getRoles().add("FE");
        em.persist(project1);

        // 4. 프로젝트 번역(다국어) 데이터 넣기
        ProjectTranslation pt1 = new ProjectTranslation();
        pt1.setProject(project1);
        pt1.setLanguage(ko);
        pt1.setTitle("손빛");
        pt1.setSubtitle("병원 회원가입 및 근무 시간 설정 UI");
        pt1.setDescription("병원 회원가입 시 요일별 근무 및 휴게 시간을 설정하는 복잡한 UI 로직을 구현한 프로젝트입니다.");
        em.persist(pt1);

        System.out.println("=====================================");
        System.out.println("🎉 더미 데이터가 성공적으로 들어갔습니다!");
        System.out.println("=====================================");
    }
}
