package com.example.nounours.Favorites;

import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nounours.Data.DataFavorites;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.nounours.Controllers.FavoritesController;
import com.example.nounours.Data.DataFavoritesList;
import com.example.nounours.Favorites.FavoritesAdapter;

public class FavoritesContent implements FavoritesAdapter.OnFilmClickListener {

    public static final List<FavoritesItem> ITEMS = new ArrayList<FavoritesItem>();

    public static final Map<Integer, FavoritesItem> ITEM_MAP = new HashMap<Integer, FavoritesItem>();

    private static RecyclerView VIEW;

    public FavoritesContent() {

    }

    @Override
    public void onFilmClick(FavoritesItem mItem) {
        //put data to bundle and startActivity
        Log.d("1", "onfilmclick");
        Log.d("2", mItem.title);
    }

    public void getItems(int page, RecyclerView view) {
        FavoritesController controller = new FavoritesController();
        String token = controller.getToken();
        String session = "";
        int accountId = 0;
        if (token != "") {
            session = controller.getSessionId(token);
        }
        if (session != "") {
            accountId = controller.getAccountID(session);
        }
        if (accountId != 0) {
            controller.getFavorites(page, this, session, accountId);
        }

        VIEW = view;
    }

    public void setItems(DataFavorites values) {
        for (int i = 0; i < values.res.length; i++) {
            addItem(createFavoritesItem(values.res[i]));
        }
        FavoritesAdapter adpt = new FavoritesAdapter(ITEMS);
        adpt.setListener(this);
        VIEW.setAdapter(adpt);
    }

    private static void addItem(FavoritesItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static FavoritesItem createFavoritesItem(DataFavoritesList item) {
        return new FavoritesItem(
            item.id,
            item.title,
            item.language,
            item.overview,
            item.release_date,
            item.genre_ids,
            item.vote_average,
            item.vote_count,
            makeDetails(item.title, item.language, item.release_date)
        );
    }

    private static String makeDetails(String title, String language, String release_date) {
        StringBuilder builder = new StringBuilder();
        builder.append(title.toUpperCase());
        builder.append("\nLanguage: ").append(language);
        builder.append(", Release date: ").append(release_date);
        return builder.toString();
    }

    public static class FavoritesItem {
        public final int id;
        public final String title;
        public final String language;
        public final String overview;
        public final String release_date;
        public final int genres [];
        public final float vote_avg;
        public final float vote_count;

        public final String desc;

        public FavoritesItem(int id, String title, String language, String overview, String release_date, int genres [], float vote_avg, float vote_count, String desc) {
            this.id = id;
            this.title = title;
            this.language = language;
            this.overview = overview;
            this.release_date = release_date;
            this.genres = genres;
            this.vote_avg = vote_avg;
            this.vote_count = vote_count;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}