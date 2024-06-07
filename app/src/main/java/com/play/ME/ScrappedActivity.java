package com.play.ME;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ScrappedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrapped);

        ScrollView scrollView = findViewById(R.id.scrollView);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.nav_community) {
                    startActivity(new Intent(ScrappedActivity.this, CommunityActivity.class));
                    return true;
                } else if (itemId == R.id.nav_home) {
                    startActivity(new Intent(ScrappedActivity.this, MainActivity.class));
                    return true;
                } else if (itemId == R.id.nav_mypage) {
                    startActivity(new Intent(ScrappedActivity.this, MypageActivity.class));
                    return true;
                }
                return false;
            }
        });



    }
}
