package com.example.smse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.annotation.NonNull;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Fragment_channel fragmentchannel = new Fragment_channel();
    private Fragment_club fragmentclub = new Fragment_club();
    private Fragment_mypage fragmentmypage = new Fragment_mypage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.menu_frame_layout, fragmentchannel).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());

    }


    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (menuItem.getItemId()) {
                case R.id.first_tab:
                    transaction.replace(R.id.menu_frame_layout, fragmentmypage).commitAllowingStateLoss();
                    break;
                case R.id.second_tab:
                    transaction.replace(R.id.menu_frame_layout, fragmentchannel).commitAllowingStateLoss();
                    break;
                case R.id.third_tab:
                    transaction.replace(R.id.menu_frame_layout, fragmentclub).commitAllowingStateLoss();
                    break;

            }

            return true;
        }
    }
}