package com.example.umc9th.domain.PreferenceFood;

import com.example.umc9th.domain.Category.Category;
import com.example.umc9th.domain.User.User;
import jakarta.persistence.*;

@Entity
@Table(name = "preference_food")
public class PreferenceFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id1", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id2", nullable = false)
    private Category category;

    protected PreferenceFood() {}
}
