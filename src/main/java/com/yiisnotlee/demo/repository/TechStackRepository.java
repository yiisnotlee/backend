package com.yiisnotlee.demo.repository;

import com.yiisnotlee.demo.domain.techstack.TechStack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechStackRepository extends JpaRepository<TechStack, Long> {
}
