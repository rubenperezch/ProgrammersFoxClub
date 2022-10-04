package com.greenfoxacademy.programmerfoxclub.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @OneToMany (mappedBy = "user")
    List<Fox> listOfFoxes = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, Fox fox) {
        this.username = username;
        this.password = password;
        this.listOfFoxes.add(fox);
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Fox> getListOfFoxes() {
        return listOfFoxes;
    }

    public void setListOfFoxes(List<Fox> listOfFoxes) {
        this.listOfFoxes = listOfFoxes;
    }
}
