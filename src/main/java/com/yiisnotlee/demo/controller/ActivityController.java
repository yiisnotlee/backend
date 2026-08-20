package com.yiisnotlee.demo.controller;

import com.yiisnotlee.demo.domain.activity.Activity;
import com.yiisnotlee.demo.dto.ActivityResponse;
import com.yiisnotlee.demo.repository.ActivityRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ActivityController {

    private final ActivityRepository activityRepository;

    public ActivityController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @GetMapping("/api/activities")
    @Transactional(readOnly = true)
    public List<ActivityResponse> getActivities(
            @RequestParam(defaultValue = "ko") String language) {

        List<Activity> activities = activityRepository.findAll();

        return activities.stream()
                .map(p -> new ActivityResponse(p, language))
                .collect(Collectors.toList());
    }
}