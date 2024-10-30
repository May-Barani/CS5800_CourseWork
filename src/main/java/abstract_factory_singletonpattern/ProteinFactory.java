package abstract_factory_singletonpattern;

import abstract_factory_singletonpattern.macronutrients.Protein;
import abstract_factory_singletonpattern.macronutrients.Macronutrient;

public class ProteinFactory extends MacronutrientFactory {
    @Override
    Macronutrient createMacronutrient() {
        return new Protein();
    }
}
