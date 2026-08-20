package com.yiisnotlee.demo.controller;

import com.yiisnotlee.demo.domain.profile.Profile;
import com.yiisnotlee.demo.dto.ProfileResponse;
import com.yiisnotlee.demo.repository.ProfileRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProfileController {

    private final ProfileRepository profileRepository;

    public ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @GetMapping("/api/profiles")
    @Transactional(readOnly = true)
    public List<ProfileResponse> getProfiles(
            @RequestParam(defaultValue = "ko") String language) {

        List<Profile> profiles = profileRepository.findAll();

        return profiles.stream()
                .map(p -> new ProfileResponse(p, language))
                .collect(Collectors.toList());
    }
}