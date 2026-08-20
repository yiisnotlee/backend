package com.yiisnotlee.demo.repository;

import com.yiisnotlee.demo.domain.profile.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
