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
        touristAttractions = new ArrayList<TouristAttraction>(List.of(
                new TouristAttraction(getTouristAttractId(), "Amalienborg Slot", "Slot"),
                new TouristAttraction(getTouristAttractId(),"Tivoli", "Forlystelsespark"),
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
        int index = 0;
        for (int i = 0; i<touristAttractions.size(); i++) {
            if (touristAttractions.get(i).getId() == updatedAttraction.getId())
                index = 1;
        }
        touristAttractions.set(index, updatedAttraction);
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
    }


