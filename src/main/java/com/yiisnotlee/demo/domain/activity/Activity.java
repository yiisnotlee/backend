package com.yiisnotlee.demo.domain.activity;

import com.yiisnotlee.demo.domain.profile.Profile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "activities")
@Getter
@Setter
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isOngoing;
    private Integer sortOrder;

    @OneToMany(mappedBy = "activity")
    private List<ActivityTranslation> translations = new ArrayList<>();
}
