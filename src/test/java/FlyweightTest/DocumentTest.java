package FlyweightTest;

import Flyweight.CharacterProperties;
import Flyweight.Document;
import Flyweight.FlyweightFactory;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DocumentTest {
    private static final String TEST_FILE_PATH = "testDocument.txt";

    @Test
    void testAddCharacterAndGetDocumentString() {
        FlyweightFactory factory = new FlyweightFactory();
        Document document = new Document();

        document.addCharacter('H', factory.getFlyweight("Arial", "Red", 12));
        document.addCharacter('e', factory.getFlyweight("Arial", "Red", 12));
        document.addCharacter('l', factory.getFlyweight("Verdana", "Black", 16));
        document.addCharacter('l', factory.getFlyweight("Arial", "Red", 12));
        document.addCharacter('o', factory.getFlyweight("Verdana", "Black", 16));

        assertEquals("Hello", document.getDocumentString(), "Document content should match added characters");
    }

    @Test
    void testSaveAndLoadDocument() throws IOException {
        FlyweightFactory factory = new FlyweightFactory();
        Document document = new Document();

        //Add characters to the document
        document.addCharacter('T', factory.getFlyweight("Arial", "Red", 12));
        document.addCharacter('E', factory.getFlyweight("Calibri", "Blue", 14));
        document.addCharacter('S', factory.getFlyweight("Verdana", "Black", 16));
        document.addCharacter('T', factory.getFlyweight("Arial", "Red", 12));
        document.addCharacter('I', factory.getFlyweight("Calibri", "Blue", 14));
        document.addCharacter('N', factory.getFlyweight("Arial", "Black", 16));
        document.addCharacter('G', factory.getFlyweight("Consolas", "Blue", 12));

        //Save the document
        document.save(TEST_FILE_PATH);

        //Load the document
        Document loadedDocument = new Document();
        loadedDocument.load(TEST_FILE_PATH, factory);

        //Verify
        assertEquals(document.getDocumentString(), loadedDocument.getDocumentString(), "Loaded document should match saved content");

    }
}
