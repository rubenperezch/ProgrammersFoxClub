package com.greenfoxacademy.programmerfoxclub.Services;

import com.greenfoxacademy.programmerfoxclub.Models.Fox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FoxList {

    List<Fox> foxList;

    public FoxList() {
        foxList = new ArrayList<>();

        Fox marcos = new Fox("Marcos");
        foxList.add(marcos);
    }

    public void addFox(String name) {
        if (foxList.contains(name)) {

        } else {
            Fox fox = new Fox(name);
            foxList.add(fox);

        }
    }

    public List<Fox> returnFoxList() {
        return foxList;
    }
}
