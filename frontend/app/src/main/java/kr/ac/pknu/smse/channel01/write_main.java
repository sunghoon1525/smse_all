package kr.ac.pknu.smse.channel01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class write_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_main);

        final ImageButton back_write =(ImageButton)findViewById(R.id.back_write);
        back_write.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(write_main.this, channel_main.class);
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
                                Intent intent = new Intent(write_main.this, channel_main.class);
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