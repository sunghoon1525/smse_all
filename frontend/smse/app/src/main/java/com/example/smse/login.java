package com.example.smse;

import static kr.ac.pknu.smse.channel01.Server.checkServer;
import static kr.ac.pknu.smse.channel01.Server.connect;
import static kr.ac.pknu.smse.channel01.Server.resultFromServer;
import static kr.ac.pknu.smse.channel01.Server.save;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    public static EditText textID, textPW;
    public static String id, pw, idpw;
    public static boolean a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textID = (EditText) findViewById(R.id.edittext3);
        textPW = (EditText) findViewById(R.id.edittext4);

        connect();

        final ImageButton signup1 = (ImageButton) findViewById(R.id.imagebutton3);
        final ImageButton findid = (ImageButton) findViewById(R.id.imagebutton1);
        final ImageButton findpw = (ImageButton) findViewById(R.id.imagebutton2);
        final Button btn_login = (Button) findViewById(R.id.btn_login);

        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, signup1.class);
                startActivity(intent);
            }
        });
        findid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, findid.class);
                startActivity(intent);
            }
        });

        findpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, findpassword.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = textID.getText().toString();
                pw = textPW.getText().toString();
                String str = "login/"+id+"/"+pw;
                checkServer(str);
                String ab1 = save();
                while (true){
                    ab1 = save();
                    if (ab1 != null){
                        break;
                    }
                }
                String ab = save();
                System.out.println("java : " + ab);
                if (ab.equals("True")){
                    Toast.makeText(getApplicationContext(), "로그인 성공!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    ab1 = null;
                    Toast.makeText(getApplicationContext(),"로그인 실패!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


