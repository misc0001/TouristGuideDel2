package com.example.touristguidedel2.controller;

import com.example.touristguidedel2.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("attractions")
public class TouristController {

    TouristService touristService;
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("")
    public String showAttractions(Model model) {
        model.addAttribute("tourist", touristService.getAllAttractions());
        return "attraction-index";
    }
}
