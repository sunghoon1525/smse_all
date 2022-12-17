package com.example.smse;

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
        // 이거를 파이썬 함수에 넣어서 true면 넘어가고 아니면 다음페이지로 못넘어가게 해주실수있나요
        // 파이썬 함수를 불러오는건 따로 뭐 설치해야함

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
    }
}
