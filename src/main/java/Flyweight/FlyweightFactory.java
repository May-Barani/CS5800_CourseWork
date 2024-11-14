package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private Map<String, CharacterProperties> flyweights = new HashMap<>();

    public CharacterProperties getFlyweight(String font, String color, int size) {
        String key = font + color + size;
        flyweights.putIfAbsent(key, new CharacterProperties(font, color, size));
        return flyweights.get(key);
    }
}
