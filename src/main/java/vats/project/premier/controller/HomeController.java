package vats.project.premier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vats.project.premier.models.data.AchievementRepository;
import vats.project.premier.models.data.GameRepository;
import vats.project.premier.models.data.ReviewRepository;

@Controller
public class HomeController {

    @Autowired
    private AchievementRepository achievementRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @RequestMapping("")
    public String displayHomePage(Model model) {
        model.addAttribute("home", "Welcome Page");

        return "index";
    }

    @RequestMapping("register")
    public String displayRegisterForm(Model model) {
        model.addAttribute("register form", "Register here");

        return "register";
    }

    @RequestMapping("achievements")
    public String displayAchievementsForm(Model model) {
        model.addAttribute("Achievements form", "Achievements");

        return "achievements";
    }

    @RequestMapping("games")
    public String displayGamesForm(Model model) {
        model.addAttribute("Games form", "Games");

        return "games";
    }

    @RequestMapping("reviews")
    public String displayReviewsForm(Model model) {
        model.addAttribute("Reviews form", "Reviews");

        return "reviews";
    }
}