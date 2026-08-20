package com.yiisnotlee.demo.domain.activity;

import com.yiisnotlee.demo.domain.language.Language;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "activities_translations",
        uniqueConstraints = @UniqueConstraint(columnNames = {"activity_id", "language_code"}))
@Getter
@Setter
public class ActivityTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_id", nullable = false)
    private Activity activity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_code", nullable = false)
    private Language language;

    @Column(length = 1000)
    private String description;

}
