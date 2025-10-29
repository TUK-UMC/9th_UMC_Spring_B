package com.example.umc9th.domain.Store;

import com.example.umc9th.domain.Menu.Menu;
import com.example.umc9th.domain.Mission.Mission;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id1;

    @Column(name = "explain", nullable = false, length = 100)
    private String explain;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 10)
    private String score;

    @Column(nullable = false, length = 100)
    private String situation;

    @OneToMany(mappedBy = "store")
    private List<Menu> menus = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<Mission> missions = new ArrayList<>();

    protected Store() {}
}
