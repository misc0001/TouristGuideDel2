package com.example.touristguidedel2.controller;

import com.example.touristguidedel2.model.TouristAttraction;
import com.example.touristguidedel2.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("attractions")
public class TouristController {

    private final TouristService touristService;
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("")
    public String showAttractions(Model model) {
        model.addAttribute("tourist", touristService.getAllAttractions());
        return "attraction-index";
    }

    @GetMapping("/edit/name")
    public String editAttractions(@RequestParam String name, Model model) {
        TouristAttraction attraction = touristService.findByName(name);
        if (attraction != null) {
            model.addAttribute("attraction", attraction);
            return "attraction-edit";
        } else {
            return "attraction-not-found";
        }
    }
    @PostMapping("/update/name")
    public String updateAttraction(@ModelAttribute TouristAttraction attraction, Model model) {
        touristService.editAttraction(attraction.getName(), attraction);
        model.addAttribute("attraction", attraction);
        return "attraction-edit";
    }

}
