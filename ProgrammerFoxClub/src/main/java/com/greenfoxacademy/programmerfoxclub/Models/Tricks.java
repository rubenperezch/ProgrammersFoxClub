package com.greenfoxacademy.programmerfoxclub.Models;

import javax.persistence.*;

@Entity
public enum Tricks {

    DanceOneLegged, PlayTitanicOnFlute, ShaveWithGlass, PlayDead;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fox_id")
    private Fox fox;
}
