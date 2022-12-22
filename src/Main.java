import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        Album album = new Album("Album1","AC/DC");
        album.addSongToAlbum("TNT",4.5);
        album.addSongToAlbum("Highway to hell",3.5);
        album.addSongToAlbum("ThunderStruck",5.0);
        albums.add(album);
        album = new Album("Album2","Eminem");
        album.addSongToAlbum("Rap God",4.5);
        album.addSongToAlbum("Not Afraid",3.5);
        album.addSongToAlbum("Lose yourself",5.0);
        albums.add(album);
        LinkedList<Song> playList_1 = new LinkedList<>();
        albums.get(0).addToPlayList("TNT",playList_1);
        albums.get(0).addToPlayList("Highway to hell",playList_1);
        albums.get(1).addToPlayList("Rap god",playList_1);
        albums.get(1).addToPlayList(2,playList_1);
        play(playList_1);

    }
    public static void play(LinkedList<Song> playList)
    {
        printMenu();
        ListIterator<Song> listIterator = playList.listIterator();
        boolean forward = true;
        if(playList.size()>0)
        {
            System.out.println("Playing the first song..... ");
            System.out.println(listIterator.next().toString());
        }
        else
        {
            System.out.println("PlayList is Empty");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your option : ");
        boolean quit = false;
        while (!quit)
        {
            int option = sc.nextInt();
            switch(option)
            {
                case 0 : quit = true; break;
                case 1 :
                    if(forward==false)
                    {
                        listIterator.next();
                        forward = true;
                    }
                    if(listIterator.hasNext())
                    {
                        System.out.println("Next song "+listIterator.next().toString());
                        forward = true;
                    }
                    else
                    {
                        forward = false;
                        System.out.println("You are at the last song...... ");
                    }
                    break;
                case 2 :
                    if(forward==true)
                    {
                        listIterator.previous();
                    }
                    if(listIterator.hasPrevious())
                    {
                        System.out.println("Previous song playing..."+listIterator.previous().toString());
                    }
                    else {
                        System.out.println("You are at the first song...");
                    }
                    break;
                case 3 :
                    if(forward==true)
                    {
                        if(listIterator.hasPrevious())
                        {
                            System.out.println("Repeating the song...."+listIterator.previous().toString());
                            forward = false;
                        }
                    }
                    else
                    {
                        if(listIterator.hasNext()){
                            System.out.println("Repeating the song...."+listIterator.next().toString());
                        }
                    }
                    break;
                case 4 :
                    System.out.println("Printing all the songs.....");
                    printSongs(playList);
                    break;
                case 5 :
                    printMenu();

                case 6 :
                    //


            }
        }
    }
    public static void printSongs(LinkedList<Song> playList)
    {
        for(Song song : playList)
        {
            System.out.println(song.toString()+"  ");
        }
    }
    private static void printMenu()
    {
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs\n"+
                "5 - print all available options\n"+
                "6 - delete current song"
        );
    }
}