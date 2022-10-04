package com.greenfoxacademy.programmerfoxclub.Services;

import com.greenfoxacademy.programmerfoxclub.Models.Tricks;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FoxTrick {

    List<Tricks> allTricks;

    public FoxTrick() {
        this.allTricks = new ArrayList<>();
        allTricks.add(Tricks.DanceOneLegged);
        allTricks.add(Tricks.PlayTitanicOnFlute);
        allTricks.add(Tricks.ShaveWithGlass);
        allTricks.add(Tricks.PlayDead);
    }

    public List<Tricks> getAllTricks() {
        return allTricks;
    }
}
