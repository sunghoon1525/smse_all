package com.example.smse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class mypage_authority extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_authority);

        final ImageButton back_my_page_authority =(ImageButton)findViewById(R.id.back_my_page_authority);
        back_my_page_authority.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mypage_authority.this, Fragment_mypage.class);
                startActivity(intent);
            }
        });
    }
}