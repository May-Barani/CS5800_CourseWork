package Flyweight;

public class FlyweightMain {
    private static final String FILE_PATH = "HelloWorldCS5800.txt";

    public static void main(String[] args) {
        FlyweightFactory characterFactory = new FlyweightFactory();
        Document editableDocument = new Document();

        // Adding characters with the new specified styles
        editableDocument.addCharacter('H', characterFactory.getFlyweight("Arial", "Red", 12));
        editableDocument.addCharacter('e', characterFactory.getFlyweight("Calibri", "Blue", 14));
        editableDocument.addCharacter('l', characterFactory.getFlyweight("Verdana", "Black", 16));
        editableDocument.addCharacter('l', characterFactory.getFlyweight("Arial", "Red", 12));
        editableDocument.addCharacter('o', characterFactory.getFlyweight("Calibri", "Blue", 14));
        editableDocument.addCharacter('W', characterFactory.getFlyweight("Verdana", "Black", 16));
        editableDocument.addCharacter('o', characterFactory.getFlyweight("Arial", "Red", 12));
        editableDocument.addCharacter('r', characterFactory.getFlyweight("Calibri", "Blue", 14));
        editableDocument.addCharacter('l', characterFactory.getFlyweight("Verdana", "Black", 16));
        editableDocument.addCharacter('d', characterFactory.getFlyweight("Arial", "Red", 12));
        editableDocument.addCharacter('C', characterFactory.getFlyweight("Calibri", "Blue", 14));
        editableDocument.addCharacter('S', characterFactory.getFlyweight("Verdana", "Black", 16));
        editableDocument.addCharacter('5', characterFactory.getFlyweight("Arial", "Red", 12));
        editableDocument.addCharacter('8', characterFactory.getFlyweight("Calibri", "Blue", 14));
        editableDocument.addCharacter('0', characterFactory.getFlyweight("Verdana", "Black", 16));
        editableDocument.addCharacter('0', characterFactory.getFlyweight("Arial", "Red", 12));

        // Save document to file with the new name
        editableDocument.save(FILE_PATH);

        // Load document from file
        Document loadedDocument = new Document();
        loadedDocument.load(FILE_PATH, characterFactory);

        // Print loaded document content
        System.out.println("Loaded Document Content: " + loadedDocument.getDocumentString());
    }
}
