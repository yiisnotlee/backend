package com.yiisnotlee.demo.domain.profile;

import com.yiisnotlee.demo.domain.language.Language;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "profile_translations", uniqueConstraints = @UniqueConstraint(columnNames = {"profile_id", "language_code"}))
@Getter
@Setter
public class ProfileTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_code", nullable = false)
    private Language language;

    private String name;
    private String headline;
    private String schoolName;
    private String major;
    private String address;
}
