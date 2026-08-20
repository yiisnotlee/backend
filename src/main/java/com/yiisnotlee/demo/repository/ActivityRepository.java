package com.yiisnotlee.demo.repository;

import com.yiisnotlee.demo.domain.activity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
