package com.example.smse;

import static kr.ac.pknu.smse.channel01.Server.checkServer;
import static kr.ac.pknu.smse.channel01.Server.connect;
import static kr.ac.pknu.smse.channel01.Server.save;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;


public class write_main extends AppCompatActivity {
    // about socket
    private static Handler mHandler;
    private static Socket socket;
    private static DataOutputStream outstream;
    private static DataInputStream instream;
    private static int port = 9999;

    private static CheckBox check1, check2, check3, check4;
    private static Boolean ck1, ck2, ck3, ck4, ra1, ra2, ra3, a;
    private static RadioButton radi1, radi2, radi3;
    private static int grade, channel;
    private static String resultFromServer;
    private static EditText edit1, edit2;

    TextView textView;
    String[] items = {"C.S'", "TIN", "프리킥", "프리런", "프리뫼", "프리허그"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_main);

        connect();

        textView = (TextView) findViewById(R.id.tv_club);
        //DB
        SharedPreferences pref = getSharedPreferences("Pref", Application.MODE_PRIVATE);

        check1 = (CheckBox)findViewById(R.id.check1);
        check2 = (CheckBox)findViewById(R.id.check2);
        check3 = (CheckBox)findViewById(R.id.check3);
        check4 = (CheckBox)findViewById(R.id.check4);

        radi1 = (RadioButton)findViewById(R.id.radio1);
        radi2 = (RadioButton)findViewById(R.id.radio2);
        radi3 = (RadioButton)findViewById(R.id.radio3);

        ck1 = pref.getBoolean("check1", false); // 순서대로 1,2,3,4
        ck2 = pref.getBoolean("check2", false);
        ck3 = pref.getBoolean("check3", false);
        ck4 = pref.getBoolean("check4", false);

        ra1 = pref.getBoolean("radi1", false); // 공지
        ra2 = pref.getBoolean("radi2", false); // 동아리
        ra3 = pref.getBoolean("radi3", false); // 홍보

        check1.setChecked(ck1);
        check2.setChecked(ck2);
        check3.setChecked(ck3);
        check4.setChecked(ck4);

        radi1.setChecked(ra1);
        radi2.setChecked(ra2);
        radi3.setChecked(ra3);

        edit1 = (EditText)findViewById(R.id.title); // 제목
        edit2 = (EditText)findViewById(R.id.content); // 내용

        Spinner spinner = (Spinner) findViewById(R.id.sp_club); // 동아리 목록 >> 아직 구현 X
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
//                textView.setText(items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
//                textView.setText("선택 : ");
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

                if (check1.isChecked()){grade = 1;}
                if (check2.isChecked()){grade = 2;}
                if (check3.isChecked()){grade = 3;}
                if (check4.isChecked()){grade = 4;}
                if (radi1.isChecked()){channel = 1;}
                if (radi2.isChecked()){channel = 2;}
                if (radi3.isChecked()){channel = 3;}

                String ed1 = edit1.getText().toString(); // string으로 변환
                String ed2 = edit2.getText().toString();
                String total = "send/" + ed1 + "/" + ed2 + "/" + channel + "/" + grade;

                resultFromServer = null;
                checkServer(total);
                while (true){
                    String ab = save();
                    if (ab != null){
                        break;
                    }
                }
                String ab = save();
                if (ab == "True" || ab != null){
                    AlertDialog.Builder builder = new AlertDialog.Builder(write_main.this);
                    builder.setMessage("전송 완료되었습니다");
                    builder.setTitle("전송 완료").setCancelable(false).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            checkServer(total);
                            Intent intent = new Intent(write_main.this, Fragment_channel.class);
                            startActivity(intent);
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.setTitle("전송 완료");
                    alert.show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"전송 실패!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }}