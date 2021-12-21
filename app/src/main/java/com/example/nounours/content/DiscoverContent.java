package com.example.nounours.content;

import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nounours.Data.DataDiscover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.example.nounours.Controllers.DiscoverController;
import com.example.nounours.Data.DataDiscoverList;
import com.example.nounours.DiscoverAdapter;

public class DiscoverContent {

    public static final List<DiscoverItem> ITEMS = new ArrayList<DiscoverItem>();

    public static final Map<Integer, DiscoverItem> ITEM_MAP = new HashMap<Integer, DiscoverItem>();

    private static RecyclerView VIEW;

    public DiscoverContent() {

    }

    public void getItems(int page, RecyclerView view) {
        Log.d("16", "xd");
        DiscoverController controller = new DiscoverController();
        controller.getDiscover(page, this);
        VIEW = view;
    
        // setItems(values);
    }

    public static void setItems(DataDiscover values) {
        Log.d("8", String.valueOf(values.res_nb));
        Log.d("7", String.valueOf(values.res));

        for (int i = 0; i < values.res.length; i++) {
            addItem(createDiscoverItem(values.res[i]));
        }
        VIEW.setAdapter(new DiscoverAdapter(ITEMS));
        VIEW.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                Log.d("30", "lol");
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });
    }

    private static void addItem(DiscoverItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DiscoverItem createDiscoverItem(DataDiscoverList item) {
        return new DiscoverItem(
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

    // public static int getIdFromPos(int pos) {
    //     if (pos >= ITEMS.size()) {
    //         return (-1);
    //     }
    //     return (ITEMS.get(pos).id);
    // }

    private static String makeDetails(String title, String language, String release_date) {
        StringBuilder builder = new StringBuilder();
        builder.append(title.toUpperCase());
        builder.append("\nLanguage: ").append(language);
        builder.append(", Release date: ").append(release_date);
        return builder.toString();
    }

    public static class DiscoverItem {
        public final int id;
        public final String title;
        public final String language;
        public final String overview;
        public final String release_date;
        public final int genres [];
        public final float vote_avg;
        public final float vote_count;

        public final String desc;

        public DiscoverItem(int id, String title, String language, String overview, String release_date, int genres [], float vote_avg, float vote_count, String desc) {
            this.id = id;
            this.title = title;
            this.language = language;
            this.overview = overview;
            this.release_date = release_date;
            this.genres = genres;
            this.vote_avg = vote_avg;
            this.vote_count = vote_count;
            this.desc = desc;
            Log.d("10", desc);
        }

        @Override
        public String toString() {
            return title;
        }
    }
}