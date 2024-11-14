package abstract_factory_singletonpattern;

import abstract_factory_singletonpattern.macronutrients.Fats;
import abstract_factory_singletonpattern.macronutrients.Macronutrient;

public class FatsFactory extends MacronutrientFactory {
    @Override
    Macronutrient createMacronutrient() {
        return new Fats();
    }
}
