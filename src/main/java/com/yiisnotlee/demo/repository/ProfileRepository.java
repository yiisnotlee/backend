package com.yiisnotlee.demo.repository;

import com.yiisnotlee.demo.domain.profile.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @EntityGraph(attributePaths = {"translations"})
    List<Profile> findAll();

    @EntityGraph(attributePaths = {"translations"})
    Optional<Profile> findById(Long id);
}