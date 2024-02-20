package com.example.touristguidedel2.controller;

import com.example.touristguidedel2.model.TouristAttraction;
import com.example.touristguidedel2.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("{id}/delete")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable int id) {
        TouristAttraction deleteAttraction = touristService.deleteAttraction(id);

        if (deleteAttraction != null) {
            return new ResponseEntity<>(deleteAttraction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
