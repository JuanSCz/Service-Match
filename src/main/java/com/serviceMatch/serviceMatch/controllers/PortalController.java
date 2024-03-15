package com.serviceMatch.serviceMatch.controllers;

import com.serviceMatch.serviceMatch.entities.AppUser;
import com.serviceMatch.serviceMatch.entities.Job;
import com.serviceMatch.serviceMatch.entities.Skill;
import com.serviceMatch.serviceMatch.services.ServiceJob;
import com.serviceMatch.serviceMatch.services.ServiceSkill;
import com.serviceMatch.serviceMatch.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Controller
@RequestMapping("/") // http://localhost:8080/
public class PortalController {

    @Autowired
    ServiceSkill serviceSkill;

    @Autowired
    UserService serviceUser;

    @Autowired
    ServiceJob serviceJob;

    @GetMapping("/")
    public String index(@RequestParam(name = "skill", required = false) String skill,
            @RequestParam(name = "id", required = false) Long id, ModelMap model) {
        List<Skill> skills = (List<Skill>) serviceSkill.getSkills();
        model.addAttribute("skills", skills);
        if (skill != null) {
            List<AppUser> providers = (List<AppUser>) serviceUser.loadUserBySkyll(skill);
            model.addAttribute("providers", providers);
            model.addAttribute("selectedSkill", skill);
        } else {
            List<AppUser> providers = (List<AppUser>) serviceUser.loadUserBySkyll("Plomero");
            model.addAttribute("providers", providers);
            model.addAttribute("selectedSkill", "Plomero");
        }
        List<Job> jobs = serviceJob.listJobByProvider(id);
        double totalCalification = 0.0;

        for (Job job : jobs) {
            Long callification = job.getCallification();
            if (callification != null) {
                totalCalification += callification;
            }
        }
        double averageCalification = jobs.isEmpty() ? 0.0 : totalCalification / jobs.size();
        BigDecimal roundedAverage = new BigDecimal(averageCalification).setScale(1, RoundingMode.HALF_UP);
        model.addAttribute("averageCalification", roundedAverage);
        return "index.html";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Usuario o Contraseña inválidos");
        }
        return "login.html";
    }

    @GetMapping("/register")
    public String register() {
        return "register.html";
    }
}
