package com.greenfoxacademy.programmerfoxclub.Services;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ActionList {

    List<String> actionList;

    public ActionList() {
        this.actionList = new ArrayList<>();
    }

    public List<String> getActionList() {
        return actionList;
    }

    public void addActionList(String action) {
        actionList.add(action);
    }
}
