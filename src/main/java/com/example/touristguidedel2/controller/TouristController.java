package com.example.touristguidedel2.controller;

import com.example.touristguidedel2.model.TouristAttraction;
import com.example.touristguidedel2.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;


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

    @GetMapping("/select")
    public String selectAttraction(Model model) {
        List<TouristAttraction> attractions = touristService.getAllAttractions();
        model.addAttribute("attractions", attractions);
        return "select-attraction";
    }

    @GetMapping("/edit")
    public String editAttractions(@RequestParam String name, Model model) {
        TouristAttraction attraction = touristService.findByName(name);
        List<String> cities = touristService.getCities();
        List<String> tags = touristService.getTags();
        model.addAttribute("cities", cities);
        model.addAttribute("tags", tags);
        if (attraction != null) {
            model.addAttribute("attraction", attraction);
            return "attraction-edit";
        } else {
            return "attraction-not-found";
        }
    }
    @PostMapping("/edit")
    public String updateAttraction(@ModelAttribute TouristAttraction attraction, RedirectAttributes redirectAttributes) {
        touristService.updateAttraction(attraction);
        redirectAttributes.addFlashAttribute("successMessage", "Attraction updated successfully!");
        return "redirect:/attractions";
    }



    @GetMapping("{id}/delete")
    public String deleteAttraction(@PathVariable int id) {
        touristService.deleteAttraction(id);
        return "redirect:/attractions";
    }


    @GetMapping("add")
    public String showAddedAttraction(Model model) {
        TouristAttraction newAttraction = new TouristAttraction();
        List<String> cities = touristService.getCities();
        List<String> tags = touristService.getTags();
        model.addAttribute("attraction", newAttraction);
        model.addAttribute("cities", cities);
        model.addAttribute("tags", tags);
        return "attraction-add";
    }
    @PostMapping("add")
    public String addAttraction(@ModelAttribute TouristAttraction touristAttraction) {
        touristService.addAttraction(touristAttraction);
        return "redirect:/attractions";
    }

    @GetMapping("/{id}/tags")
    public String showAttractionTags(@PathVariable int id, Model model) {
        TouristAttraction attraction = touristService.findAttractionById(id);
        if (attraction != null) {
            model.addAttribute("attraction", attraction);
            return "attraction-tags";
        } else {
            return "redirect:/attractions";
        }
    }
}
