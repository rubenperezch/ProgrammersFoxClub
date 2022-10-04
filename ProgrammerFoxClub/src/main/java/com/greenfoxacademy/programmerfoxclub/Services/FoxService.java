package com.greenfoxacademy.programmerfoxclub.Services;

import com.greenfoxacademy.programmerfoxclub.Models.Drinks;
import com.greenfoxacademy.programmerfoxclub.Models.Food;
import com.greenfoxacademy.programmerfoxclub.Models.Fox;
import com.greenfoxacademy.programmerfoxclub.Models.Tricks;
import com.greenfoxacademy.programmerfoxclub.Repositories.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FoxService {

    public FoxList foxList;

    public FoxNutrition foodList;

    public FoxNutrition drinksList;

    public FoxTrick trickList;

    public ActionList actionList;

    public FoxRepository foxRepository;

    @Autowired
    public FoxService(FoxList foxList, FoxNutrition foodList, FoxNutrition drinksList, FoxTrick trickList, ActionList actionList, FoxRepository foxRepository) {
        this.foxList = foxList;
        this.foodList = foodList;
        this.drinksList = drinksList;
        this.trickList = trickList;
        this.actionList = actionList;
        this.foxRepository = foxRepository;
    }


    public void addServiceFox(String name) {
        foxList.addFox(name);
    }

    public List<Fox> returnServiceFoxList() {
        return foxList.returnFoxList();
    }

    public Fox returnFox(String name) {
        return foxList.returnFoxList().stream().filter(e -> e.getName().equals(name)).findAny().get();
    }

    public Integer countTricks(String name) {
        return foxList.returnFoxList().stream().filter(e -> e.getName().equals(name)).findAny().get().getListOfTricks().size();
    }

    public void setFoxFood(String name, Food food) {
        foxList.returnFoxList().stream().filter(e -> e.getName().equals(name)).findAny().get().setFood(food);
        String action = name + " changed food to: " + food;
        actionList.addActionList(action);
    }

    public void setFoxDrink(String name, Drinks drink) {
        foxList.returnFoxList().stream().filter(e -> e.getName().equals(name)).findAny().get().setDrink(drink);
        String action = name + " changed drink to: " + drink;
        actionList.addActionList(action);
    }

    public void setFoxTricks(String name, Tricks trick) {
        foxList.returnFoxList().stream().filter(e -> e.getName().equals(name)).findAny().get().addTrick(trick);
        String action = name + " learnt a new trick: " + trick;
        actionList.addActionList(action);
    }

    public List<Tricks> getAllTricks(){
        return trickList.getAllTricks();
    }

    public List<Tricks> getFoxTricks(String name) {
        return foxList.returnFoxList().stream().filter(e -> e.getName().equals(name)).findAny().get().getListOfTricks();
    }

    public List<Tricks> getAvailableTricks(String name) {   //instead of getAllTricks
        List<Tricks> differences = new ArrayList<>(trickList.getAllTricks());
        differences.removeAll(foxList.returnFoxList().stream().filter(e -> e.getName().equals(name)).findAny().get().getListOfTricks());

        return differences;
    }

    public Integer countAvailable(String name) {
        List<Tricks> differences = new ArrayList<>(trickList.getAllTricks());
        differences.removeAll(foxList.returnFoxList().stream().filter(e -> e.getName().equals(name)).findAny().get().getListOfTricks());

        return differences.size();
    }

    public List<String> getActionList() {
        return actionList.getActionList();
    }

    public void saveFox(Fox fox) {
        foxRepository.save(fox);
    }
}
