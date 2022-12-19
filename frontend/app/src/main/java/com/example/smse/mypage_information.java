package com.example.smse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class mypage_information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_information);

        final ImageButton ack_information =(ImageButton)findViewById(R.id.back_information);
        ack_information.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mypage_information.this, Fragment_mypage.class);
                startActivity(intent);
            }
        });
    }
}