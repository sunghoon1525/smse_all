package com.example.smse;

import static kr.ac.pknu.smse.channel01.Server.checkServer;
import static kr.ac.pknu.smse.channel01.Server.save;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class channel_notice extends AppCompatActivity {
    private static TextView date, sender, title, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.channel_notion);
        checkServer("notice");
        String ab = save();

        date = (TextView) findViewById(R.id.dateandtime);
        sender = (TextView) findViewById(R.id.sender);
        title = (TextView) findViewById(R.id.noticetitle);
        message = (TextView) findViewById(R.id.noticecontent);

        String[] a = ab.split("\\-\\+\\-");
        String b = a[0];

        if (a.length > 1) {
            System.out.println("0 : " +a[0]);
            System.out.println("1 : " +a[1]);
            System.out.println("2 : " +a[2]);
            System.out.println("3 : " +a[3]);

            title.setText(a[0]);
            message.setText(a[1]);
            date.setText(a[2]);
            sender.setText(a[3]);
        }
        else{
            System.out.println(b);
        }


        final ImageButton backnotion =(ImageButton)findViewById(R.id.back_notion);
        backnotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(channel_notice.this, Fragment_channel.class);
                startActivity(intent);
            }
        });

    }
}