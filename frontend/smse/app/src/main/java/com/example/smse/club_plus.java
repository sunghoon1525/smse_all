package com.example.smse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class club_plus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_plus);

        final ImageButton back_club_plus =(ImageButton)findViewById(R.id.back_club_plus);
        back_club_plus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(club_plus.this, Fragment_club.class);
                startActivity(intent);
            }
        });
    }
}