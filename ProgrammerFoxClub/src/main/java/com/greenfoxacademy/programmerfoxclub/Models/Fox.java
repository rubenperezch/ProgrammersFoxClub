package com.greenfoxacademy.programmerfoxclub.Models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    public Food food;
    public Drinks drink;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany (mappedBy = "fox")
    private List<Tricks> listOfTricks;

    public Fox(String name) {
        this.name = name;
        this.food = Food.Takoyaki;
        this.drink = Drinks.CalpisSoda;
        this.listOfTricks = new ArrayList<>();

    }

    public Fox(String name, Food food, Drinks drink, User user, List<Tricks> listOfTricks) {
        this.name = name;
        this.food = food;
        this.drink = drink;
        this.user = user;
        this.listOfTricks = listOfTricks;
    }

    public Fox(String name, Food food, Drinks drink, List<Tricks> listOfTricks) {
        this.name = name;
        this.food = food;
        this.drink = drink;
        this.listOfTricks = listOfTricks;
    }

    public Fox() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Drinks getDrink() {
        return drink;
    }

    public void setDrink(Drinks drink) {
        this.drink = drink;
    }

    public List<Tricks> getListOfTricks() {
        return listOfTricks;
    }

    public void setListOfTricks(List<Tricks> listOfTricks) {
        this.listOfTricks = listOfTricks;
    }

    public void addTrick(Tricks trick) {
        listOfTricks.add(trick);
    }




}

