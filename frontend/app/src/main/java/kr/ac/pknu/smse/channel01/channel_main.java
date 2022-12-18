package kr.ac.pknu.smse.channel01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class channel_main extends AppCompatActivity {

    private mainFragment fragmentManager = getSupportmainFragment();
    private MainMenuChartFragment fragmentChart = new MainMenuChartFragment();
    private MainMenuSearchFragment fragmentSearch = new MainMenuSearchFragment();
    private MainMenuMoreFragment fragmentMore = new MainMenuMoreFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.channel_main);

        final Button notion =(Button)findViewById(R.id.notion);
        notion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(channel_main.this, channel_notice.class);
                startActivity(intent);
            }
        });

        final Button promotion =(Button)findViewById(R.id.promotion);
        promotion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(channel_main.this, channel_promotion.class);
                startActivity(intent);
            }
        });

        final Button club =(Button)findViewById(R.id.club);
        club.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(channel_main.this, channel_club.class);
                startActivity(intent);
            }
        });

        final ImageButton write =(ImageButton)findViewById(R.id.plus_write);
        write.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(channel_main.this, write_main.class);
                startActivity(intent);
            }
        });

    }
}