package kr.ac.pknu.smse.channel01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class signup2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        final Button btn =(Button) findViewById(R.id.btn_signup2);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup2.this, login.class);
                startActivity(intent);
            }
        });

        final ImageButton back =(ImageButton)findViewById(R.id.back_signup2);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup2.this, signup1.class);
                startActivity(intent);
            }
        });
    }
}