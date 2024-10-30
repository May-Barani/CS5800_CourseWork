package abstract_factory_singletonpattern;

import abstract_factory_singletonpattern.macronutrients.Carbs;
import abstract_factory_singletonpattern.macronutrients.Macronutrient;

public class CarbsFactory extends MacronutrientFactory{
    @Override
    Macronutrient createMacronutrient() {
        return new Carbs();
    }
}
