package kr.ac.pknu.smse.channel01;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class login extends AppCompatActivity {

    public static EditText textID, textPW;
    public static String id, pw, resultFromServer;
    public static boolean a;
    // about socket
    private static Handler mHandler;
    private static Socket socket;
    private static DataOutputStream outstream;
    private static DataInputStream instream;
    private static int port = 9999;

    public void connect() { // socket과 연결
        mHandler = new Handler(Looper.getMainLooper());
        Log.w("connect", "연결 하는중");
        Thread checkUpdate = new Thread() {
            public void run() {
                // Access server
                try {
                    socket = new Socket("192.168.0.22", port); //ip 주소 작성
                    Log.w("서버 접속됨", "서버 접속됨");
                } catch (IOException e1) {
                    Log.w("서버 접속 못함", "서버 접속 못함");
                    e1.printStackTrace();
                }
                Log.w("edit 넘어가야 할 값 : ", "안드로이드에서 서버로 연결 요청");
                try {
                    outstream = new DataOutputStream(socket.getOutputStream());
                    instream = new DataInputStream(socket.getInputStream());
                    outstream.writeUTF("안드로이드에서 서버로 연결 요청");
                } catch (IOException e) {
                    e.printStackTrace();

                }
                Log.w("버퍼", "버퍼 생성 잘 됨");
                try {
                    while (true) {
                        String idpw = id + "/" + pw; // 아이디와 비밀번호를 묶어서 보냄 >> / 로 슬라이싱 하여 사용할 수 있게

                        byte[] idBytes = idpw.getBytes();
                        ByteBuffer b1 = ByteBuffer.allocate(4);
                        b1.order(ByteOrder.LITTLE_ENDIAN);
                        b1.putInt(idBytes.length);
                        outstream.write(b1.array(), 0, 4);
                        outstream.write(idBytes);

                        // 결과 수신
                        byte[] data = new byte[16];
                        int n = instream.read(data);
                        resultFromServer = new String(data, 0, n);
                        Log.i("서버에서 받은 결과 : ", resultFromServer);
                        a = resultFromServer.equals("True");
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        checkUpdate.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textID = (EditText) findViewById(R.id.edittext3);
        textPW = (EditText) findViewById(R.id.edittext4);


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

        final Button btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // id, pw 전송
                String id = textID.getText().toString();
                String pw = textPW.getText().toString();

                connect(id, pw);

                if (a){
                    Toast.makeText(getApplicationContext(), "로그인 성공!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this, channel_main.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"로그인 실패!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


