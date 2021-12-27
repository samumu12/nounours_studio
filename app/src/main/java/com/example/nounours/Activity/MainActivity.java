package com.example.nounours.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.example.nounours.Discover.DiscoverFragment;
import com.example.nounours.Favorites.FavoritesFragment;
import com.example.nounours.R;
import com.example.nounours.Research.ResearchFragment;
import com.example.nounours.Research.ResearchBarFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        setContentView(R.layout.activity_main);

        // Navigation

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.placeholder, new DiscoverFragment(this))
                .commit();
        }

        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.nav_view);
        navigationView.setOnNavigationItemSelectedListener(item -> {
            // Handle item selection
            switch (item.getItemId()) {
                case R.id.discover:
                    getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.placeholder, new DiscoverFragment(this))
                        .commit();
                    return true;
                case R.id.favorites:
                    getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.placeholder, new FavoritesFragment())
                        .commit();
                    return true;
                case R.id.research:
                    getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.placeholder, new ResearchBarFragment(this))
                        .commit();
                    return true;
                default:
                    return false;
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }
}