package abstract_factory_singletonpattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MealTest {

    @Test
    void testMealComponents() {
        Meal meal = new Meal("Bread", "Tofu", "Avocado");
        assertEquals("Bread", meal.getCarbs(), "Carbs should be 'Bread'");
        assertEquals("Tofu", meal.getProtein(), "Protein should be 'Tofu'");
        assertEquals("Avocado", meal.getFats(), "Fats should be 'Avocado'");
    }
}
