package com.example.smse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class channel_promotion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.channel_promotion);

        final ImageButton backpromotion =(ImageButton)findViewById(R.id.back_promotion);
        backpromotion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(channel_promotion.this, Fragment_channel.class);
                startActivity(intent);
            }
        });

    }
}