package kr.ac.pknu.smse.channel01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mypage_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_main);

        Button logout_my_page = (Button) findViewById(R.id.logout_my_page);
        logout_my_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mypage_main.this);
                builder.setMessage("로그아웃 하시겠습니까?");
                builder.setTitle("").setCancelable(false).setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        //여기 아랫 부분에 channel_main.class 부분 로그인 하는 페이지 이름으로 변경해야함
                        Intent intent = new Intent(mypage_main.this, channel_main.class);
                        startActivity(intent);
                    }
                }).setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.setTitle("");
                alert.show();
            }
        });


        Button unregister_my_page = (Button) findViewById(R.id.unregister_my_page);
        unregister_my_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mypage_main.this);
                builder.setMessage("회원탈퇴 하시겠습니까?\n" +
                        "\n" +
                        "탈퇴 이후 이지수 님의\n" +
                        "개인정보는 안전하게 삭제되며,\n" +
                        "이후 복구 할 수 없습니다.");
                builder.setTitle("").setCancelable(false).setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        //여기 아랫 부분에 channel_main.class 부분 로그인 하는 페이지 이름으로 변경해야함
                        Intent intent = new Intent(mypage_main.this, channel_main.class);
                        startActivity(intent);
                    }
                }).setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.setTitle("");
                alert.show();
            }
        });
    }
}