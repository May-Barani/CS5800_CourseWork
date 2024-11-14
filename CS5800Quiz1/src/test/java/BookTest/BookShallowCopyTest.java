package BookTest;

import Book.BookShallowCopy;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BookShallowCopyTest {

    @Test
    void testShallowCopy() throws CloneNotSupportedException {
        // Setup original book
        List<String> chapters = new ArrayList<>();
        chapters.add("Chapter 1");
        chapters.add("Chapter 2");
        BookShallowCopy originalBook = new BookShallowCopy("Shallow Book", "Author A", chapters);

        // Clone
        BookShallowCopy clonedBook = (BookShallowCopy) originalBook.clone();

        // Modify
        originalBook.getChapters().add("Chapter 3");

        // Verify
        assertEquals(originalBook.getChapters(), clonedBook.getChapters());
        assertEquals(3, clonedBook.getChapters().size(), "Cloned book should also contain 3 chapters");
    }

    @Test
    void testDifferentTitle() throws CloneNotSupportedException {
        // Setup original book
        List<String> chapters = new ArrayList<>();
        chapters.add("Chapter 1");
        BookShallowCopy originalBook = new BookShallowCopy("Shallow Book", "Author A", chapters);

        // Clone
        BookShallowCopy clonedBook = (BookShallowCopy) originalBook.clone();

        // Modify
        clonedBook.setTitle("Modified Title");

        // Verify
        assertNotEquals(originalBook.getTitle(), clonedBook.getTitle());
    }
}
