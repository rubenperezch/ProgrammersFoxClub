package com.greenfoxacademy.programmerfoxclub.Controllers;

import com.greenfoxacademy.programmerfoxclub.Models.Drinks;
import com.greenfoxacademy.programmerfoxclub.Models.Food;
import com.greenfoxacademy.programmerfoxclub.Models.Fox;
import com.greenfoxacademy.programmerfoxclub.Models.Tricks;
import com.greenfoxacademy.programmerfoxclub.Services.FoxService;
import com.greenfoxacademy.programmerfoxclub.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    FoxService foxService;

    UserService userService;

    @Autowired
    public MainController(FoxService foxService, UserService userService) {
        this.foxService = foxService;
        this.userService = userService;
    }

    @GetMapping("/main")
    public String renderHome(Model model, @RequestParam(name = "name", defaultValue = "Marcos") String name) {
        model.addAttribute("fox", foxService.returnFox(name));
        model.addAttribute("count", foxService.countTricks(name));
        model.addAttribute("currentTricks",foxService.getFoxTricks(name));


        return "main";
    }

    @PostMapping("/main")
    public String returnHome(Model model, @RequestParam String name) {
        model.addAttribute("fox", foxService.returnFox(name));

        return "main";
    }

    @GetMapping("/login")
    public String renderLogin() {

        return "pet-login";
    }

    @PostMapping("/login")
    public String returnLogin(@RequestParam String name) {
        foxService.addServiceFox(name);

        return "redirect:/?name=" + name;
    }

    @GetMapping("/nutritionStore")
    public String renderNutrition(Model model, @RequestParam(required = false) String name) {
        model.addAttribute("fox", foxService.returnFox(name));
        model.addAttribute("foods", foxService.foodList.getFoodList());
        model.addAttribute("drinks", foxService.drinksList.getDrinksList());

        return "nutrition";
    }

    @PostMapping("nutritionStore")
    public String returnNutrition(Model model, @RequestParam String name, @RequestParam Food food, @RequestParam Drinks drink) {
        model.addAttribute("fox", foxService.returnFox(name));
        foxService.setFoxFood(name, food);
        foxService.setFoxDrink(name, drink);

        return "redirect:/nutritionStore?name=" + name;
    }

    @GetMapping("/trickCenter")
    public String renderTrick(Model model, @RequestParam(required = false) String name) {
        model.addAttribute("fox", foxService.returnFox(name));
        model.addAttribute("countAvailable",foxService.countAvailable(name));
        model.addAttribute("tricks",foxService.getAvailableTricks(name));
        model.addAttribute("count", foxService.countTricks(name));
        model.addAttribute("currentTricks",foxService.getFoxTricks(name));

        return "trick";
    }

    @PostMapping("/trickCenter")
    public String returnTrick(Model model, @RequestParam(required = false) String name, @RequestParam Tricks trick) {
        model.addAttribute("fox", foxService.returnFox(name));
        model.addAttribute("countAvailable",foxService.countAvailable(name));
        model.addAttribute("tricks",foxService.getAvailableTricks(name));
        model.addAttribute("count", foxService.countTricks(name));
        model.addAttribute("currentTricks",foxService.getFoxTricks(name));

        foxService.setFoxTricks(name, trick);

        return "redirect:/trickCenter?name=" +name;
    }

    @GetMapping("/history")
    public String renderHistory(Model model) {
        model.addAttribute("actions",foxService.getActionList());

        return "history";
    }

    @GetMapping("/register")
    public String renderRegister() {
         return "register";
    }

    @PostMapping("/register")
    public String returnRegister(@RequestParam String user, @RequestParam String password, @RequestParam String foxName, @RequestParam String repeatPassword) {
        if (password.equals(repeatPassword)) {
            foxService.saveFox(new Fox(foxName));
            userService.saveUser(user,password,foxName);

            return"redirect:/main";
        } else {

            return "failed-register";
        }

    }

    @GetMapping("/")
    public String renderHome() {
        return "index";
    }

    @PostMapping("/")
    public String returnHome(@RequestParam String user, @RequestParam String password) {
        return null;
    }
}
