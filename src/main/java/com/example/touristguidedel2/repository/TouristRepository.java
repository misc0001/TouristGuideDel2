package com.example.touristguidedel2.repository;

import com.example.touristguidedel2.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private int touristAttractId;

    private List<TouristAttraction> touristAttractions;

    public TouristRepository() {
        touristAttractId = 1;
        touristAttractions = new ArrayList<>(List.of(
                new TouristAttraction(getTouristAttractId(), "Amalienborg Slot", "Slot"),
                new TouristAttraction(getTouristAttractId(), "Tivoli", "Forlystelsespark"),
                new TouristAttraction(getTouristAttractId(), "Fredensborg Slot", "Slot"),
                new TouristAttraction(getTouristAttractId(), "København Zoo", "Zoo")
        ));

    }

    private int getTouristAttractId() {
        return touristAttractId++;
    }

    public List<TouristAttraction> getAllAttractions() {
        return touristAttractions;
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

    public void deleteAttraction(int id) {
        TouristAttraction removeAttraction = null;
        for (TouristAttraction touristAttraction : touristAttractions) {
            if (touristAttraction.getId() == id)
                removeAttraction = touristAttraction;

        }
        if (removeAttraction != null)
            touristAttractions.remove(removeAttraction);
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

}


