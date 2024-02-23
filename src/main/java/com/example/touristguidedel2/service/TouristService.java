package com.example.touristguidedel2.service;

import com.example.touristguidedel2.model.TouristAttraction;
import com.example.touristguidedel2.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    private TouristRepository touristRepository;

    @Autowired
    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }
    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.getAllAttractions();
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
    public void deleteAttraction(int id) {
        touristRepository.deleteAttraction(id);
    }
    public TouristAttraction findByName(String name) {
       return touristRepository.findByName(name);
    }
}
