package ProxyTest;

import Proxy.Song;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SongTest {
    @Test
    public void testSongAttributes() {
        //for testing
        Song song = new Song(6, "Typa Girl", "BlackPink", "Born Pink", 186);

        // Verifying each attribute
        assertEquals(6, song.getId());
        assertEquals("Typa Girl", song.getTitle());
        assertEquals("BlackPink", song.getArtist());
        assertEquals("Born Pink", song.getAlbum());
        assertEquals(186, song.getDuration());
    }

    @Test
    public void testSongToString() {
        //Using "Typa Girl" for testing
        Song song = new Song(6, "Typa Girl", "BlackPink", "Born Pink", 186);

        //Expected output
        String expected = "Song{id=6, title='Typa Girl', artist='BlackPink', album='Born Pink', duration=186}";

        //Verifying output
        assertEquals(expected, song.toString());
    }
}
