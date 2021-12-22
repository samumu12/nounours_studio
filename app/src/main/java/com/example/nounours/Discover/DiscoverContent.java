package com.example.nounours.Discover;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nounours.Activity.FilmActivity;
import com.example.nounours.Activity.MainActivity;
import com.example.nounours.Data.DataDiscover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.nounours.Controllers.DiscoverController;
import com.example.nounours.Data.DataDiscoverList;

public class DiscoverContent extends FragmentActivity implements DiscoverAdapter.OnFilmClickListener {

    public static final List<DiscoverItem> ITEMS = new ArrayList<DiscoverItem>();
    private Context _context;

    public static final Map<Integer, DiscoverItem> ITEM_MAP = new HashMap<Integer, DiscoverItem>();

    private static RecyclerView VIEW;

    public DiscoverContent(Context context) {
        _context = context;
    }

    @Override
    public void onFilmClick(DiscoverItem mItem) {
        Intent intent = new Intent(_context, FilmActivity.class);

        intent.putExtra("title", mItem.title);
        intent.putExtra("id", mItem.id);
        intent.putExtra("desc", mItem.desc);
        intent.putExtra("language", mItem.language);
        intent.putExtra("overview", mItem.overview);
        intent.putExtra("release_date", mItem.release_date);
        intent.putExtra("vote_avg", mItem.vote_avg);
        intent.putExtra("vote_count", mItem.vote_count);

        _context.startActivity(intent);
    }

    public void getItems(int page, RecyclerView view) {
        DiscoverController controller = new DiscoverController();
        controller.getDiscover(page, this);
        VIEW = view;
    }

    public void setItems(DataDiscover values) {
        for (int i = 0; i < values.res.length; i++) {
            addItem(createDiscoverItem(values.res[i]));
        }
        DiscoverAdapter adpt = new DiscoverAdapter(ITEMS);
        adpt.setListener(this);
        VIEW.setAdapter(adpt);
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
        }

        @Override
        public String toString() {
            return title;
        }
    }
}