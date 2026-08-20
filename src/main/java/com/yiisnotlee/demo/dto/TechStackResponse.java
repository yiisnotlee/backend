package com.yiisnotlee.demo.dto;

import com.yiisnotlee.demo.domain.techstack.TechStack;
import lombok.Getter;

@Getter
public class TechStackResponse {
    private Long id;
    private String category;
    private String name;
    private String iconUrl;
    private int sortOrder;

    public TechStackResponse(TechStack techStack) {
        this.id = techStack.getId();
        this.category = techStack.getCategory();
        this.name = techStack.getName();
        this.iconUrl = techStack.getIconUrl();
        this.sortOrder = techStack.getSortOrder();
    }
}