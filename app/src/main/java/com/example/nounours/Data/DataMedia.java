package com.example.nounours.Data;

public class DataMedia {

    String media_type;
    int media_id;
    boolean favorite;

    public DataMedia(String type, int id, boolean IsFavorite) {
        media_type = type;
        media_id = id;
        favorite = IsFavorite;
    }
}
