package com.yiisnotlee.demo.dto;

import com.yiisnotlee.demo.domain.activity.Activity;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ActivityResponse {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isOngoing;
    private int sortOrder;

    private String description;

    public ActivityResponse(Activity activity, String langCode) {
        this.id = activity.getId();
        this.startDate = activity.getStartDate();
        this.endDate = activity.getEndDate();
        this.isOngoing = activity.getIsOngoing();
        this.sortOrder = activity.getSortOrder();

        if (activity.getTranslations() != null) {
            activity.getTranslations().stream()
                    .filter(t -> langCode.equals(t.getLanguage().getCode()))
                    .findFirst()
                    .ifPresent(translation -> {
                        this.description = translation.getDescription();
                    });
        }
    }
}
