package Proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongProxy implements SongService {
    private SongService realSongService;
    private Map<Integer, Song> idCache = new HashMap<>();
    private Map<String, List<Song>> titleCache = new HashMap<>();
    private Map<String, List<Song>> albumCache = new HashMap<>();

    public SongProxy(SongService realSongService) {
        this.realSongService = realSongService;
    }

    @Override
    public Song searchById(Integer songID) {
        if (!idCache.containsKey(songID)) {
            idCache.put(songID, realSongService.searchById(songID));
        }
        return idCache.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if (!titleCache.containsKey(title)) {
            titleCache.put(title, realSongService.searchByTitle(title));
        }
        return titleCache.get(title);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if (!albumCache.containsKey(album)) {
            albumCache.put(album, realSongService.searchByAlbum(album));
        }
        return albumCache.get(album);
    }
}
