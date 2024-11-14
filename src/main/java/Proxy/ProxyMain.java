package Proxy;

public class ProxyMain {
    public static void main(String[] args) {
        SongService songService = new SongProxy(new RealSongService());

        // First access to songs, will hit the real service and experience a delay
        System.out.println("First access, fetching from server:");
        System.out.println(songService.searchById(1));
        System.out.println(songService.searchByTitle("Expresso"));
        System.out.println(songService.searchByAlbum("Born Pink"));

        // Second access to the same songs, will use cache and avoid delay
        System.out.println("\nSecond access, fetching from cache:");
        System.out.println(songService.searchById(1));
        System.out.println(songService.searchByTitle("Expresso"));
        System.out.println(songService.searchByAlbum("Born Pink"));
    }
}

