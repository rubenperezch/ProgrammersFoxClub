package com.greenfoxacademy.programmerfoxclub.Services;

import com.greenfoxacademy.programmerfoxclub.Models.Drinks;
import com.greenfoxacademy.programmerfoxclub.Models.Food;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FoxNutrition {

    List<Food> foodList;

    List<Drinks> drinksList;

    public FoxNutrition() {
        this.foodList = new ArrayList<>();
        foodList.add(Food.Takoyaki);
        foodList.add(Food.Babguyas);
        foodList.add(Food.Paella);
        foodList.add(Food.Gominolas);
        foodList.add(Food.Burundanga);

        this.drinksList = new ArrayList<>();
        drinksList.add(Drinks.CalpisSoda);
        drinksList.add(Drinks.Borovicka);
        drinksList.add(Drinks.PocariSweat);
        drinksList.add(Drinks.Palinka);
        drinksList.add(Drinks.Vermouth);
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public List<Drinks> getDrinksList() {
        return drinksList;
    }

    public void setDrinksList(List<Drinks> drinksList) {
        this.drinksList = drinksList;
    }
}
