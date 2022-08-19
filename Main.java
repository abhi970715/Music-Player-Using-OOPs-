package com.example.mypackage;

import java.util.*;

public class Main {
    private static Scanner scan=new Scanner(System.in);
    private static ArrayList<Album> albums=new ArrayList<>();
    public static void main(String[] args) {

	    Album album=new Album("Morning","Imagine Dragon");
        album.addSong("Monster",4.05);
        album.addSong("Believer",5.00);
        album.addSong("Radioactive",3.30);
        album.addSong("Thunder",4.00);
        albums.add(album);

        album=new Album("Evening","Eminem");
        album.addSong("Rap God",5.00);
        album.addSong("Not Afraid",5.05);
        album.addSong("Lose Yourself",4.05);
        albums.add(album);

        LinkedList<Song> playList_1=new LinkedList<>();
        albums.get(0).addToPlayList("Monster",playList_1);
        albums.get(0).addToPlayList("Thunder",playList_1);
        albums.get(1).addToPlayList("Rap God",playList_1);
        albums.get(1).addToPlayList("Lose Yourself",playList_1);

        play(playList_1);

    }
    public static  void play(LinkedList<Song> playList){
        boolean quit=false;
        boolean forward=true;
        ListIterator<Song> listIterator=playList.listIterator();
        if(playList.isEmpty())
            System.out.println("This playlist is empty");
        else{
            System.out.println("Now playing "+listIterator.next().toString());
            printMenu();
        }
        while(!quit){
            int action=scan.nextInt();
            switch(action){

                case 0:
                    System.out.println("Playlist Complete");
                    quit=true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now Playing "+listIterator.next().toString());
                    }else{
                        System.out.println("No song available , reached to the end of the list");
                        forward=false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;

                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now Playing "+listIterator.previous().toString());

                    }
                    else{
                        System.out.println("First Song");
                        forward =false;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now Playing "+listIterator.previous().toString());
                            forward=false;
                        }
                        else{
                            System.out.println("We are at the start of the list");
                        }
                    }
                    else{
                        if(listIterator.hasNext()){
                            System.out.println("Now Playing "+listIterator.next().toString());
                            forward=true;
                        }
                        else{
                            System.out.println("We are at the end of the list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(!playList.isEmpty()){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now Playing "+listIterator.next().toString());
                        }
                        else{
                            if(listIterator.hasPrevious()) {
                                System.out.println("Now Playing "+listIterator.previous().toString());
                            }
                        }
                    }
            }
        }
    }
    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n" +
                           "1 - to play next Song\n" +
                           "2 - to play the previous song\n" +
                           "3 - to replay the current song\n" +
                           "4 - list of all songs\n" +
                           "5 - print all available options\n" +
                           "6 - delete the current song ");
    }
    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator=playList.iterator();
        System.out.println("-------------------------");

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-------------------------");
    }
}
