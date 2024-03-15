package com.example.touristguidedel2.repository;

import com.example.touristguidedel2.model.TouristAttraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TouristRepositoryTest {
    private TouristRepository touristRepository;
    private int getTouristAttractId() {
        return 0;
    }
    @BeforeEach
    void setUp() {
        touristRepository = new TouristRepository();
    }

    @Test
    void getAllAttractions() {
        List<TouristAttraction> touristAttractions = touristRepository.getAllAttractions();
        assertEquals(4, touristAttractions.size());
    }

    @Test
    void addAttraction() {
        TouristAttraction newAttraction = new TouristAttraction(getTouristAttractId(), "New Attraction", "New Desctiption", "New City", List.of("Tag 1", "Tag 2"));
        touristRepository.addAttraction(newAttraction);

        TouristAttraction retrievedAttraction = touristRepository.findAttractionById(newAttraction.getId());
        assertEquals(newAttraction, retrievedAttraction);
    }

    @Test
    void updateAttraction() {
        int attractionId = 1;

        TouristAttraction updatedAttraction = new TouristAttraction(attractionId, "Bakken", "Forlystelsespark", "København", List.of("Sjov", "frisk luft"));
        touristRepository.updateAttraction(updatedAttraction);

        TouristAttraction retrievedAttraction = touristRepository.findAttractionById(attractionId);
        assertEquals(updatedAttraction, retrievedAttraction);
    }

    @Test
    void deleteAttraction() {
        int attractionIdToDelete = 2;

        TouristAttraction deletedAttraction = touristRepository.deleteAttraction(attractionIdToDelete);

        assertEquals("Tivoli", deletedAttraction.getName());
        assertNull(touristRepository.findAttractionById(attractionIdToDelete));
    }
}