package kr.ac.pknu.smse.channel01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class channel_club extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.channel_club);

        final ImageButton backclub =(ImageButton)findViewById(R.id.back_club);
        backclub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(channel_club.this, channel_main.class);
                startActivity(intent);
            }
        });

    }
}
