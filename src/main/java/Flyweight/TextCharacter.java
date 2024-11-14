package Flyweight;

public class TextCharacter {
    private char character;
    private CharacterProperties properties;

    public TextCharacter(char character, CharacterProperties properties) {
        this.character = character;
        this.properties = properties;
    }

    public char getCharacter() {
        return character;
    }

    public CharacterProperties getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return character + " [" + properties + "]";
    }
}
