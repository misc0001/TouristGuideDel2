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
        touristAttractions = new ArrayList<>(List.of(
                new TouristAttraction(getTouristAttractId(), "Amalienborg Slot", "Slot", "København", List.of("amalienTags", "tags2")),
                new TouristAttraction(getTouristAttractId(),"Tivoli", "Forlystelsespark", "København", List.of("tivoliTags", "tags2")),
                new TouristAttraction(getTouristAttractId(), "Fredensborg Slot", "Slot", "København", List.of("fredenbordTags", "tags2")),
                new TouristAttraction(getTouristAttractId(), "København Zoo", "Zoo", "København", List.of("zooTags", "tags2"))
        ));

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
        int index = 0;
        for (TouristAttraction touristAttraction : touristAttractions) {
            if (touristAttraction.getId() == updatedAttraction.getId()) {
                index = 1;
                break;
            }
        }
        touristAttractions.set(index, updatedAttraction);
    }
    public TouristAttraction deleteAttraction(int id) {
        TouristAttraction removeAttraction = null;
        for (TouristAttraction touristAttraction : touristAttractions) {
            if (touristAttraction.getId() == id) {
                removeAttraction = touristAttraction;
                break;
            }
        }
        if (removeAttraction != null) {
            touristAttractions.remove(removeAttraction);
        }
            return removeAttraction;
        }

    public TouristAttraction findAttractionById(int id) {
        TouristAttraction attractionFind = null;
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getId() == id)
                attractionFind = attraction;


        }
        if (attractionFind != null)
            return attractionFind;
        else
            return null;
    }

}


