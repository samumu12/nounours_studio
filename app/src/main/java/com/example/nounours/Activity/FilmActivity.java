package com.example.nounours.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nounours.Controllers.FavoritesController;
import com.example.nounours.R;

public class FilmActivity extends AppCompatActivity {
    public String _title;
    public int _id;
    public String _desc;
    public String _language;
    public String _Overview;
    public String _releaseDate;
    public float _vote_avg;
    public float _vote_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Set text for film desc
        TextView overview = (TextView)findViewById(R.id.film_info);
        overview.setText(getIntent().getStringExtra("overview"));
        TextView desc = (TextView)findViewById(R.id.film_desc);
        desc.setText(getIntent().getStringExtra("desc"));

        // Favorite button
        final Button add_fav = findViewById(R.id.add_fav);
        add_fav.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FavoritesController controller = new FavoritesController();
                String token = controller.getToken();
                String sessionID = controller.getSessionId(token);
                int accountID = controller.getAccountID(sessionID);

                controller.postFavorites(accountID, sessionID, "movie", Integer.getInteger(getIntent().getStringExtra("id")).intValue(), true);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return (true);
        }
        return (false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return (true);
    }
}
