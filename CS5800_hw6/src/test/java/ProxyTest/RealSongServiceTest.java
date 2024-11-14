package ProxyTest;

import Proxy.RealSongService;
import Proxy.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class RealSongServiceTest {
    private RealSongService realSongService;

    @BeforeEach
    public void setUp() {
        realSongService = new RealSongService();
    }

    @Test
    public void testSearchById() {
        Song song = realSongService.searchById(8);
        assertNotNull(song, "Song with ID 8 should be found");
        assertEquals("Someone You Loved", song.getTitle(), "Song title should match");
    }

    @Test
    public void testSearchByTitle() {
        List<Song> songs = realSongService.searchByTitle("Typa Girl");
        assertFalse(songs.isEmpty(), "Songs with title 'Typa Girl' should be found");
        assertEquals("Typa Girl", songs.get(0).getTitle(), "Song title should match");
    }

    @Test
    public void testSearchByAlbum() {
        List<Song> songs = realSongService.searchByAlbum("Born Pink");
        assertFalse(songs.isEmpty(), "Songs from album 'Born Pink' should be found");
        assertEquals("Born Pink", songs.get(0).getAlbum(), "Album should match");
    }

    @Test
    public void testSearchByNonExistentId() {
        Song song = realSongService.searchById(999); // Non-existent ID
        assertNull(song, "Non-existent song ID should return null");
    }

    @Test
    public void testSearchByNonExistentTitle() {
        List<Song> songs = realSongService.searchByTitle("NonExistentTitle"); // Non-existent title
        assertTrue(songs.isEmpty(), "Non-existent title should return an empty list");
    }

    @Test
    public void testSearchByNonExistentAlbum() {
        List<Song> songs = realSongService.searchByAlbum("NonExistentAlbum"); // Non-existent album
        assertTrue(songs.isEmpty(), "Non-existent album should return an empty list");
    }
}
