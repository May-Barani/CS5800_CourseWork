package abstract_factory_singletonpattern.macronutrients;
import abstract_factory_singletonpattern.DietPlan;

public interface Macronutrient {

    String getComponent(DietPlan DietType);
}
