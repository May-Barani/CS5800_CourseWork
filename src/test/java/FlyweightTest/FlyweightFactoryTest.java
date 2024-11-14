package FlyweightTest;

import Flyweight.CharacterProperties;
import Flyweight.FlyweightFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlyweightFactoryTest {

    @Test
    void testGetFlyweight() {
        FlyweightFactory factory = new FlyweightFactory();

        CharacterProperties p1 = factory.getFlyweight("Arial", "Red", 12);
        CharacterProperties p2 = factory.getFlyweight("Arial", "Red", 12);
        CharacterProperties p3 = factory.getFlyweight("Verdana", "Blue", 14);

        // p1 and p2 should be the same instance
        assertSame(p1, p2, "Same flyweight instances for identical properties");

        // p1 and p3 should be different instances
        assertNotSame(p1, p3, "New instance for different properties");
    }
}
