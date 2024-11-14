package Proxy;

import java.util.ArrayList;
import java.util.List;

public class RealSongService implements SongService {
    private List<Song> songs;

    public RealSongService() {
        songs = new ArrayList<>();
        songs.add(new Song(1, "Apt", "Rose and Bruno Mars", "Apt", 210));
        songs.add(new Song(2, "Mantra", "Jennie", "Mantra", 195));
        songs.add(new Song(3, "Flowers", "Miley Cyrus", "Endless Summer Vacation", 202));
        songs.add(new Song(4, "Cruel Summer", "Taylor Swift", "Lover", 177));
        songs.add(new Song(5, "Rewrite the Stars", "Anne-Marie and James Arthur", "The Greatest Showman: Reimagined", 225));
        songs.add(new Song(6, "Typa Girl", "BlackPink", "Born Pink", 186));
        songs.add(new Song(7, "God is a woman", "Ariana Grande", "Sweetener", 197));
        songs.add(new Song(8, "Someone You Loved", "Lewis Capaldi", "Divinely Uninspired to a Hellish Extent", 182));
        songs.add(new Song(9, "Expresso", "Sabrina Carpenter", "Short n Sweet", 159));
    }

    @Override
    public Song searchById(Integer songID) {
        simulateDelay();
        for (Song song : songs) {
            if (song.getId().equals(songID)) {
                return song;
            }
        }
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        simulateDelay();
        List<Song> results = new ArrayList<>();
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                results.add(song);
            }
        }
        return results;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        simulateDelay();
        List<Song> results = new ArrayList<>();
        for (Song song : songs) {
            if (song.getAlbum().equalsIgnoreCase(album)) {
                results.add(song);
            }
        }
        return results;
    }

    private void simulateDelay() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
}
