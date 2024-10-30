package abstract_factory_singletonpattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    void testGenerateMealForVeganDiet() {
        Customer customer = new Customer("Alice", DietPlan.Vegan);
        Meal meal = customer.generateMealBasedOnDietPlan();

        assertTrue(meal.getCarbs().equals("Bread") || meal.getCarbs().equals("Lentils") || meal.getCarbs().equals("Pistachio"),
                "Vegan carbs should not contain Cheese.");
        assertEquals("Tofu", meal.getProtein(), "Vegan protein should be 'Tofu'.");
        assertTrue(meal.getFats().equals("Avocado") || meal.getFats().equals("Peanuts"),
                "Vegan fats should only include Avocado or Peanuts.");
    }

    @Test
    void testGenerateMealForNutAllergyDiet() {
        Customer customer = new Customer("Bob", DietPlan.Nut_Allergy);
        Meal meal = customer.generateMealBasedOnDietPlan();

        assertTrue(meal.getCarbs().equals("Cheese") || meal.getCarbs().equals("Bread") || meal.getCarbs().equals("Lentils"),
                "Nut Allergy carbs should not contain Pistachio.");
        assertTrue(meal.getFats().equals("Avocado") || meal.getFats().equals("Sour cream") || meal.getFats().equals("Tuna"),
                "Nut Allergy fats should not contain Peanuts.");
    }
}
