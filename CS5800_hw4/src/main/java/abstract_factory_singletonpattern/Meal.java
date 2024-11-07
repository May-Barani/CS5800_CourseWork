package abstract_factory_singletonpattern;

import java.util.List;

public class Meal {
    private String carbs;
    private String protein;
    private String fats;

    public Meal(String carbs, String protein, String fats) {
        this.carbs = carbs;
        this.protein = protein;
        this.fats = fats;
    }

    // Getter method for carbs
    public String getCarbs() {
        return carbs;
    }

    // Getter method for protein
    public String getProtein() {
        return protein;
    }

    // Getter method for fats
    public String getFats() {
        return fats;
    }
}
