package com.yiisnotlee.demo.domain.language;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "languages")
@Getter
@Setter
public class Language {

    @Id
    private String code;
    private String name;
    private boolean isActive;
    private int sortOrder;
}
