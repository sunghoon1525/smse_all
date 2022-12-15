package kr.ac.pknu.smse.smse_all;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    final ImageButton signup1 =(ImageButton)findViewById(R.id.imagebutton3);
        signup1.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
            Intent intent = new Intent(login.this, signup1.class);
            startActivity(intent);
        }
    });
      }

    }
