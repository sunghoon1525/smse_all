package kr.ac.pknu.smse.channel01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class findidsuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findidsuccess);


        final Button btn1 = (Button) findViewById(R.id.btn_success2);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(findidsuccess.this, login.class);
                startActivity(intent);
            }
        });

        final ImageButton btn2 = (ImageButton) findViewById(R.id.back_success);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(findidsuccess.this, findid.class);
                startActivity(intent);
            }
        });
    }
}