package com.example.mypackage;


import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
   private String name;
   private String artist;
   private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public Album() {
    }
    public boolean addSong(String title,double duration){
        if(findSong(title)==null){
            songs.add(new Song(title,duration));
            System.out.println(title+" successfully added to the album");
            return true;
        }
        else{
            System.out.println("Song "+title+" already exist");
            return false;
        }
    }
    public Song  findSong(String title){
        for(Song checkedSong:songs){
            if(checkedSong.getTitle().equals(title)){
                return checkedSong;
            }

        }
        return null;
    }
    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList){
     int index=trackNumber-1;
     if(index>0 && index<=this.songs.size()){
         playList.add(this.songs.get(index));
         return true;
     }
        System.out.println("This album doesn't have song with tracknumber "+trackNumber);
     return false;
    }
    public boolean addToPlayList(String title,LinkedList<Song> PlayList){
        for (Song checkedSong:this.songs
             ) {
            if(checkedSong.getTitle().equals(title)){
                PlayList.add(checkedSong);
                return true;
            }
        }
        System.out.println(title+" there is no such song in album");
        return false;
    }
}
