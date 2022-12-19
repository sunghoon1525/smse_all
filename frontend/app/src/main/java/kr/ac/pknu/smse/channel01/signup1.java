package com.example.smse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class signup1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);

        final ImageButton back =(ImageButton)findViewById(R.id.back_signup1);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup1.this, login.class);
                startActivity(intent);
            }
        });


        final Button btn =(Button) findViewById(R.id.btn_signup1);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup1.this, signup2.class);
                startActivity(intent);
            }
        });
    }
}
//연동 확인!!!!!!