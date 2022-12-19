package com.example.smse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class write_main extends AppCompatActivity {


        TextView textView;

    String[] items = {"C.S'", "TIN", "프리킥", "프리런", "프리뫼", "프리허그"};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.write_main);

            textView = (TextView) findViewById(R.id.tv_club);

            Spinner spinner = (Spinner) findViewById(R.id.sp_club);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    this, android.R.layout.simple_spinner_item, items
            );

            // 드롭다운 클릭 시 선택 창
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // 스피너에 어댑터 설정
            spinner.setAdapter(adapter);

            // 스피너에서 선택 했을 경우 이벤트 처리
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });





        final ImageButton back_write =(ImageButton)findViewById(R.id.back_write);
        back_write.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(write_main.this, Fragment_channel.class);
                startActivity(intent);
            }
        });

        Button send_massage = (Button) findViewById(R.id.send_massage);
        send_massage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(write_main.this);
                builder.setMessage("전송 완료되었습니다");
                builder.setTitle("전송 완료").setCancelable(false).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                Intent intent = new Intent(write_main.this, Fragment_channel.class);
                                startActivity(intent);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("전송 완료");
                alert.show();
            }
        });
    }
}