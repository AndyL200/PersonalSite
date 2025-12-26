package com.personal.webpage.Pages.Landing;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LandingController {
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to the Landing Page!");
        return "landing";
    }

}
