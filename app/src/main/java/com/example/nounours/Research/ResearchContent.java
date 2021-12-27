package com.example.nounours.Research;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nounours.Activity.FilmActivity;
import com.example.nounours.Controllers.ResearchController;
import com.example.nounours.Data.DataSearch;
import com.example.nounours.Data.DataSearchList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResearchContent extends FragmentActivity implements ResearchAdapter.OnFilmClickListener {

    public static List<ResearchItem> ITEMS = new ArrayList<ResearchItem>();
    private Context _context;

    public static Map<Integer, ResearchItem> ITEM_MAP = new HashMap<Integer, ResearchItem>();

    private static RecyclerView VIEW;

    public ResearchContent(Context context) {
        _context = context;
    }

    @Override
    public void onFilmClick(ResearchItem mItem) {
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

    public void getItems(String text, RecyclerView view) {
        ResearchController controller = new ResearchController();
        Log.d("3", "ta daronne suce des bites d'ours");
        controller.getResearch(text, this);
        VIEW = view;
    }

    public void setItems(DataSearch values) {
        ITEMS = new ArrayList<ResearchItem>();
        ITEM_MAP = new HashMap<Integer, ResearchItem>();

        for (int i = 0; i < values.res.length; i++) {
            addItem(createResearchItem(values.res[i]));
        }
        ResearchAdapter adpt = new ResearchAdapter(ITEMS);
        adpt.setListener(this);
        VIEW.setAdapter(adpt);
    }

    private static void addItem(ResearchItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static ResearchItem createResearchItem(DataSearchList item) {
        return new ResearchItem(
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

    public static class ResearchItem {
        public final int id;
        public final String title;
        public final String language;
        public final String overview;
        public final String release_date;
        public final int genres [];
        public final float vote_avg;
        public final float vote_count;

        public final String desc;

        public ResearchItem(int id, String title, String language, String overview, String release_date, int genres [], float vote_avg, float vote_count, String desc) {
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