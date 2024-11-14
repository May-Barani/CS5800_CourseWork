package ProxyTest;

import Proxy.Song;
import Proxy.RealSongService;
import Proxy.SongProxy;
import Proxy.SongService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SongProxyTest {
    private SongService songProxy;
    private RealSongService realSongService;

    @BeforeEach
    public void setUp() {
        realSongService = new RealSongService();
        songProxy = new SongProxy(realSongService);
    }

    @Test
    public void testSearchByIdWithCaching() {
        long startTime = System.currentTimeMillis();
        Song firstAccess = songProxy.searchById(7);
        long durationFirstAccess = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        Song secondAccess = songProxy.searchById(7);
        long durationSecondAccess = System.currentTimeMillis() - startTime;

        assertNotNull(firstAccess, "First access should return a valid song");
        assertNotNull(secondAccess, "Second access should return a valid song");
        assertEquals("God is a woman", firstAccess.getTitle(), "Title should match");

        assertTrue(durationSecondAccess < durationFirstAccess, "Second access should be faster due to caching");
    }

    @Test
    public void testSearchByTitleWithCaching() {
        long startTime = System.currentTimeMillis();
        List<Song> firstAccess = songProxy.searchByTitle("Typa Girl");
        long durationFirstAccess = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        List<Song> secondAccess = songProxy.searchByTitle("Typa Girl");
        long durationSecondAccess = System.currentTimeMillis() - startTime;

        assertFalse(firstAccess.isEmpty(), "First access should return songs");
        assertFalse(secondAccess.isEmpty(), "Second access should return songs");
        assertEquals("Typa Girl", firstAccess.get(0).getTitle(), "Title should match");

        assertTrue(durationSecondAccess < durationFirstAccess, "Second access should be faster due to caching");
    }

    @Test
    public void testSearchByAlbumWithCaching() {
        long startTime = System.currentTimeMillis();
        List<Song> firstAccess = songProxy.searchByAlbum("Born Pink");
        long durationFirstAccess = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        List<Song> secondAccess = songProxy.searchByAlbum("Born Pink");
        long durationSecondAccess = System.currentTimeMillis() - startTime;

        assertFalse(firstAccess.isEmpty(), "First access should return songs");
        assertFalse(secondAccess.isEmpty(), "Second access should return songs");
        assertEquals("Born Pink", firstAccess.get(0).getAlbum(), "Album should match");

        assertTrue(durationSecondAccess < durationFirstAccess, "Second access should be faster due to caching");
    }
}
