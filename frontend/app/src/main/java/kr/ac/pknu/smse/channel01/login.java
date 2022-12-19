package com.example.smse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final ImageButton signup1 = (ImageButton) findViewById(R.id.imagebutton3);
        signup1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, signup1.class);
                startActivity(intent);
            }
        });
        final ImageButton findid = (ImageButton) findViewById(R.id.imagebutton1);
        findid.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, findid.class);
                startActivity(intent);
            }
        });

        final ImageButton findpw = (ImageButton) findViewById(R.id.imagebutton2);
        findpw.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, findpassword.class);
                startActivity(intent);
            }
        });

        final Button btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}


