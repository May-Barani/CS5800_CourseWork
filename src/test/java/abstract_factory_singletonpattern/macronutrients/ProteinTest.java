package abstract_factory_singletonpattern.macronutrients;

import abstract_factory_singletonpattern.DietPlan;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProteinTest {

    @Test
    void testGetComponentForPaleoDiet() {
        Protein protein = new Protein();
        String component = protein.getComponent(DietPlan.Paleo);
        assertTrue(component.equals("Fish") || component.equals("Chicken") || component.equals("Beef"),
                "Paleo diet should not contain Tofu.");
    }

    @Test
    void testGetComponentForNoRestrictionDiet() {
        Protein protein = new Protein();
        String component = protein.getComponent(DietPlan.No_Restriction);
        assertTrue(component.equals("Fish") || component.equals("Chicken") || component.equals("Beef") || component.equals("Tofu"),
                "No Restriction diet should include all protein options.");
    }
}
