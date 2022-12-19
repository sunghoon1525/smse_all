package com.example.smse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class changepassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);
        final ImageButton back = (ImageButton) findViewById(R.id.back_changepw);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(changepassword.this, findpassword.class);
                startActivity(intent);
            }

        });

            Button button = (Button) findViewById(R.id.btn_changepw);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(changepassword.this);
                    builder.setMessage("비밀번호가 변경되었습니다.");
                    builder.setTitle("변경 완료").setCancelable(false).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            Intent intent = new Intent(changepassword.this, login.class);
                            startActivity(intent);
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.setTitle("변경 완료");
                    alert.show();
                }
            });

    }
}
