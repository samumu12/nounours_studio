package com.example.nounours;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    boolean islogged = false;
    
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
                .add(R.id.fragment_container_view, DiscoverFragment.class, null)
                .commit();
        }
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            // Handle item selection
            switch (item.getItemId()) {
                case R.id.discover:
                    setContentView(R.layout.activity_login);
                    return true;
                case R.id.favorites:
                    setContentView(R.layout.activity_login);
                    return true;
                case R.id.research:
                    setContentView(R.layout.activity_login);
                    return true;
                default:
                    return false;
            }
        });

        // var navView = findViewById<BottomNavigationView>(R.id.nav_view);
        // var navController = findNavController(R.id.nav_fragment);
        // navView.setupWithNavController(navController);
        // NavigationView navigationView = findViewById(R.id.nav_view);
        // navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            
        // });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }
}