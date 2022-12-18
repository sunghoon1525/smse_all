package kr.ac.pknu.smse.channel01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class findpassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findpassword);

        final Button btn =(Button) findViewById(R.id.btn_findpw);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(findpassword.this, changepassword.class);
                startActivity(intent);
            }
        });

        final ImageButton back =(ImageButton)findViewById(R.id.back_findpw);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(findpassword.this, login.class);
                startActivity(intent);
            }
        });
    }
}