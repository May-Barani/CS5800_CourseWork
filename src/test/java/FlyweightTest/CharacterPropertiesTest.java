package FlyweightTest;

import Flyweight.CharacterProperties;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CharacterPropertiesTest {

    @Test
    void testCharacterPropertiesCreation() {
        CharacterProperties properties = new CharacterProperties("Arial", "Red", 12);
        assertEquals("Arial", properties.getFont());
        assertEquals("Red", properties.getColor());
        assertEquals(12, properties.getSize());
    }
}
