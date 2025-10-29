package com.example.umc9th.domain.Category;

import com.example.umc9th.domain.PreferenceFood.PreferenceFood;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<PreferenceFood> preferenceFoods = new ArrayList<>();

    protected Category() {}

    public Category(String name) {
        this.name = name;
    }
}
