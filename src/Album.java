import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    String album_Name;
    String artist_Name;

    ArrayList<Song> songs;

    public Album(String album_Name,String artist_Name)
    {
        this.album_Name = album_Name;
        this.artist_Name = artist_Name;
        this.songs = new ArrayList<>();
    }
    public boolean findSong(String title)
    {
        for(Song s:songs)
        {
            if(s.getTitle().equalsIgnoreCase(title))
                return true;
        }
        return false;
    }
    public void addSongToAlbum(String title,double duration)
    {
        if(findSong(title)==true)
        {
            System.out.println("The song is already present in the Album");
        }
        else {
            Song newSong =  new Song(title,duration);
            songs.add(newSong);
            System.out.println("New Song has been added to album");
        }

    }
    public void addToPlayList(int trackNo, LinkedList<Song> playList)
    {
        int index = trackNo-1;
        if(index>=0 && index< songs.size())
        {
            Song song = this.songs.get(index);
            playList.add(song);
        }
    }
    public void addToPlayList(String title, LinkedList<Song> playList)
    {
        for(Song song : this.songs)
        {
            if(song.getTitle().equalsIgnoreCase(title))
            {
                playList.add(song);
            }
        }
    }
}
