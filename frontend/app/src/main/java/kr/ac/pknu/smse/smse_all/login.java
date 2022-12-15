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

        //입력받은 아이디와 비밀번호를 변수에 저장
        inputId = (EditText) findViewById(R.id.edittext3);
        inputPw = (EditText) findViewById(R.id.edittext4);
        
    final ImageButton signup1 =(ImageButton)findViewById(R.id.imagebutton3);
        signup1.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
            Intent intent = new Intent(login.this, signup1.class);
            startActivity(intent);
            // 입력받은 아이디와 비밀번호를 변수에 저장해야함.
        }
    });
      }

    }
