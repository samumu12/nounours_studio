package com.example.nounours;

import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;

public class MenuActivity extends AppCompatActivity {

    // @Override
    // public boolean onCreateOptionsMenu(Menu menu) {
    //     MenuInflater inflater = getMenuInflater();
    //     inflater.inflate(R.menu.menu_bar, menu);
    //     return(true);
    // }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
                return super.onOptionsItemSelected(item);
        }
    }
}
