package com.example.touristguidedel2.model;

import java.util.List;
import java.util.Objects;

public class TouristAttraction {
    private int id;
    private String name;
    private String description;
    private String city;
    private List<String> tags;
    public TouristAttraction() {

    }

    public TouristAttraction(int id, String name, String description, String city, List<String> tags) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.city = city;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TouristAttraction that)) return false;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription());
    }
}
