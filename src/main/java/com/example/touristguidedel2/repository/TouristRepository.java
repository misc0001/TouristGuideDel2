package com.example.touristguidedel2.repository;

import com.example.touristguidedel2.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class TouristRepository {
    private int touristAttractId;

    private List<TouristAttraction> touristAttractions;

    public TouristRepository() {
        touristAttractId = 1;
    }

    private int getTouristAttractId() {
        return touristAttractId++;
    }

    public List<TouristAttraction> getAllAttractions() {
        return touristAttractions;
    }

    public List<String> getCities() {
        return Arrays.asList("København", "Odense", "Aarhus");
    }
    public List<String> getTags() {
        return Arrays.asList("Børnevenlig", "Gratis", "Kunst", "Museum", "Natur");
    }

    public void addAttraction(TouristAttraction touristAttraction) {
        touristAttraction.setId(getTouristAttractId());
        touristAttractions.add(touristAttraction);
    }

    public void updateAttraction(TouristAttraction updatedAttraction) {
        for (int i = 0; i < touristAttractions.size(); i++) {
            if (touristAttractions.get(i).getId() == updatedAttraction.getId()) {
                touristAttractions.set(i, updatedAttraction);
                break;
            }
        }
    }


    public TouristAttraction deleteAttraction(int id) {
        TouristAttraction removeAttraction = null;
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getId() == id)
                removeAttraction = attraction;
        }
        if (removeAttraction != null)
            touristAttractions.remove(removeAttraction);
        return removeAttraction;
    }


  

    public TouristAttraction editAttraction(String name, TouristAttraction editAttraction) {
        for (TouristAttraction touristAttraction : touristAttractions) {
            if (touristAttraction.getName().equals(name)) {
                touristAttraction.setDescription(editAttraction.getDescription());
                return touristAttraction;
            }
        }
        return null;
    }

    public TouristAttraction findByName(String name) {
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getName().equals(name)) {
                return attraction;
            }
        }
        return null;
    }


    public TouristAttraction findAttractionById(int id) {
        TouristAttraction attractionFind = null;
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getId() == id) {
                attractionFind = attraction;
            }
        }
        if (attractionFind != null)
            return attractionFind;
        else
            return null;
    }

}


