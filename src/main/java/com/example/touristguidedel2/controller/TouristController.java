package com.example.touristguidedel2.controller;

import com.example.touristguidedel2.model.TouristAttraction;
import com.example.touristguidedel2.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("attractions/{name}/edit")
    public String editAttractions(@PathVariable String name, Model model) {
        TouristAttraction attraction = touristService.findByName(name);
        if (attraction != null) {
            model.addAttribute("attraction", attraction);
            return "attraction-edit"; // Name of the view for editing attractions
        } else {
            return "attraction-not-found";

        }
    }
    }
