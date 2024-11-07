package abstract_factory_singletonpattern;

public class MacronutrientFactory_Singleton {
        private static MacronutrientFactory_Singleton instance;
        private final MacronutrientFactory carbsFactory;
        private final MacronutrientFactory proteinFactory;
        private final MacronutrientFactory fatsFactory;

        private MacronutrientFactory_Singleton() {
            carbsFactory = new CarbsFactory();
            proteinFactory = new ProteinFactory();
            fatsFactory = new FatsFactory();
        }

        public static MacronutrientFactory_Singleton getInstance() {
            if (instance == null) {
                instance = new MacronutrientFactory_Singleton();
            }
            return instance;
        }

        public MacronutrientFactory getCarbsFactory() {
            return carbsFactory;
        }

        public MacronutrientFactory getProteinFactory() {
            return proteinFactory;
        }

        public MacronutrientFactory getFatsFactory() {
            return fatsFactory;
        }
    }

