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
    public void addAttraction(TouristAttraction touristAttraction) {
        touristRepository.addAttraction(touristAttraction);
    }
    public void updateAttraction(TouristAttraction updatedAttraction) {
        touristRepository.updateAttraction(updatedAttraction);
    }
    public void deleteAttraction(int id) {
        touristRepository.deleteAttraction(id);
    }
    public TouristAttraction findByName(String name) {
       return touristRepository.findByName(name);
    }
}
