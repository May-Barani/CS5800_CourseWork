package BookTest;

import Book.BookDeepCopy;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BookDeepCopyTest {

    @Test
    void testDeepCopy() throws CloneNotSupportedException {
        //Setup original book
        List<String> chapters = new ArrayList<>();
        chapters.add("Chapter 1");
        chapters.add("Chapter 2");
        BookDeepCopy originalBook = new BookDeepCopy("Deep Book", "Author B", chapters);

        //Clone
        BookDeepCopy clonedBook = (BookDeepCopy) originalBook.clone();

        //Modify
        originalBook.getChapters().add("Chapter 3");

        //Verify
        assertNotEquals(originalBook.getChapters(), clonedBook.getChapters());
        assertEquals(2, clonedBook.getChapters().size(), "Cloned book should contain only 2 chapters");
    }

    @Test
    void testDifferentAuthor() throws CloneNotSupportedException {
        //Setup original book
        List<String> chapters = new ArrayList<>();
        chapters.add("Chapter 1");
        BookDeepCopy originalBook = new BookDeepCopy("Deep Book", "Author B", chapters);

        //Clone
        BookDeepCopy clonedBook = (BookDeepCopy) originalBook.clone();

        //Modify
        clonedBook.setAuthor("Modified Author");

        //Verify
        assertNotEquals(originalBook.getAuthor(), clonedBook.getAuthor());
    }
}
