package vats.project.premier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import vats.project.premier.models.Achievement;
import vats.project.premier.models.data.AchievementRepository;

import javax.validation.Valid;

@Controller
public class AchievementController {

    @Autowired
    private AchievementRepository achievementRepository;

    @RequestMapping("achievements")
    public String displayAchievementsForm(Model model) {
        model.addAttribute("title", "Add an Achievement");
        model.addAttribute("achievements", achievementRepository.findAll());
        model.addAttribute(new Achievement());
        return "achievements";
    }

    @PostMapping("achievements")
    public String processGamesForm(@ModelAttribute @Valid Achievement newAchievement, Errors errors, Model model){
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add an Achievement");
            model.addAttribute("achievements", achievementRepository.findAll());
            return "achievements";
        }
        achievementRepository.save(newAchievement);
        return "redirect:/achievements";
    }

    @GetMapping("deleteAchievement")
    public String displayDeleteAchievementForm(Model model) {
        model.addAttribute("title", "Delete Achievements");
        model.addAttribute("achievements", achievementRepository.findAll());
        return "deleteAchievement";
    }
    @PostMapping("deleteAchievement")
    public String processDeleteAchievementForm(@RequestParam(required = false) int[] achievementIds) {
        if (achievementIds != null) {
            for (int id : achievementIds) {
                achievementRepository.deleteById(id);
            }
        }
        return "redirect:/deleteAchievement";
    }
}
