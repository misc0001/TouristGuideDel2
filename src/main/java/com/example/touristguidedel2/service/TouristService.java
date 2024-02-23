package com.example.touristguidedel2.service;

import com.example.touristguidedel2.model.TouristAttraction;
import com.example.touristguidedel2.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    private TouristRepository touristRepository;

    public TouristService() {
        touristRepository = new TouristRepository();
    }
    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.getAllAttractions();
    }
    public List<String> getCities() {
        return touristRepository.getCities();
    }
    public List<String> getTags() {
        return touristRepository.getTags();
    }
    public void addAttraction(TouristAttraction touristAttraction) {
        touristRepository.addAttraction(touristAttraction);
    }

    public void editAttraction(String name, TouristAttraction updatedAttraction) {
        touristRepository.editAttraction(name, updatedAttraction);
    }
    public void updateAttraction(TouristAttraction touristAttraction){
        touristRepository.updateAttraction(touristAttraction);
    }

    public TouristAttraction findByName(String name) {
       return touristRepository.findByName(name);
    }

    public void deleteAttraction(int id) {
        touristRepository.deleteAttraction(id);
    }

    public TouristAttraction findAttractionById(int id) {
        return touristRepository.findAttractionById(id);
    }
}
