package com.example.touristguidedel2.service;

import com.example.touristguidedel2.model.TouristAttraction;
import com.example.touristguidedel2.repository.TouristRepository;
import com.example.touristguidedel2.repository.TouristRepository_DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    private TouristRepository touristRepository;
    private TouristRepository_DB touristRepository_db;

    @Autowired
    public TouristService(TouristRepository touristRepository, TouristRepository_DB touristRepository_db) {
        this.touristRepository = touristRepository;
        this.touristRepository_db = touristRepository_db;
    }

    public List<TouristAttraction> getAllAttractions() {
        //return touristRepository_db.getTouristAttractions();
        return touristRepository_db.getTouristAttractions();
    }
    public List<String> getCities() {
        return touristRepository.getCities();
    }
    public List<String> getTags() {
        return touristRepository.getTags();
    }
    public void addAttraction(TouristAttraction touristAttraction) {
        touristRepository_db.addAttraction(touristAttraction);
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
        touristRepository_db.deleteAttraction(id);
    }

    public TouristAttraction findAttractionById(int id) {
        return touristRepository.findAttractionById(id);
    }
}
