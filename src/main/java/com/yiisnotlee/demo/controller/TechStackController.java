package com.yiisnotlee.demo.controller;

import com.yiisnotlee.demo.domain.techstack.TechStack;
import com.yiisnotlee.demo.dto.TechStackResponse;
import com.yiisnotlee.demo.repository.TechStackRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TechStackController {

    private final TechStackRepository techStackRepository;

    public TechStackController(TechStackRepository techStackRepository) {
        this.techStackRepository = techStackRepository;
    }

    @GetMapping("/api/tech-stacks")
    @Transactional(readOnly = true)
    public List<TechStackResponse> getTechStacks() {

        List<TechStack> techStacks = techStackRepository.findAll();

        return techStacks.stream()
                .map(TechStackResponse::new)
                .collect(Collectors.toList());
    }
}