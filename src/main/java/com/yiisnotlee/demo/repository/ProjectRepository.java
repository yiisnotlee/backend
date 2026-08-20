package com.yiisnotlee.demo.repository;

import com.yiisnotlee.demo.domain.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
