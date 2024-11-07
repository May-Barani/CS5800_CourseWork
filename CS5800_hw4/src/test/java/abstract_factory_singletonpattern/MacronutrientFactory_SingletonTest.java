package abstract_factory_singletonpattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;

class MacronutrientFactory_SingletonTest {

    @Test
    void testSingletonInstance() {
        MacronutrientFactory_Singleton instance1 = MacronutrientFactory_Singleton.getInstance();
        MacronutrientFactory_Singleton instance2 = MacronutrientFactory_Singleton.getInstance();
        assertSame(instance1, instance2, "Both instances should be the same for singleton pattern.");
    }
}
