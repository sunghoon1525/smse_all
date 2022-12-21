package com.example.smse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Server extends AppCompatActivity {
    // about socket
    private static Handler mHandler;
    private static Socket socket;
    private static DataOutputStream outstream;
    private static int port = 9999;
    public static String resultFromServer, a;
    private static DataInputStream instream;

    public static void connect() { // socket과 연결
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
            }
        };
        checkUpdate.start();
    }
//    public static void checkServer(String str){
//        mHandler = new Handler(Looper.getMainLooper());
//        Thread sendServer = new Thread() {
//            public void run(){
//                try {
//                    byte[] idBytes = str.getBytes();
//                    ByteBuffer b1 = ByteBuffer.allocate(4);
//                    b1.order(ByteOrder.LITTLE_ENDIAN);
//                    b1.putInt(idBytes.length);
//                    outstream.write(b1.array(), 0, 4);
//                    outstream.write(idBytes);
//                    // 결과 수신
//                    byte[] data = new byte[1024];
//                    int n = instream.read(data);
//                    resultFromServer = new String(data, 0, n);
//                    Log.i("", resultFromServer);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        sendServer.start();
//        System.out.println("이것이 결과야?" +resultFromServer);
//    };
    public static void checkServer(String str){
        mHandler = new Handler(Looper.getMainLooper());
        Thread sendServer = new Thread() {
            public void run(){
                try {
                    byte[] idBytes = str.getBytes();
                    ByteBuffer b1 = ByteBuffer.allocate(4);
                    b1.order(ByteOrder.LITTLE_ENDIAN);
                    b1.putInt(idBytes.length);
                    outstream.write(b1.array(), 0, 4);
                    outstream.write(idBytes);
                    // 결과 수신
                    byte[] data = new byte[1024];
                    int n = instream.read(data);
                    resultFromServer = new String(data, 0, n);
                    System.out.println(data);
                    Log.i("", resultFromServer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        sendServer.start();
        System.out.println("이것이 결과야?" +resultFromServer);
    };
    public static String save(){
        return resultFromServer;
    };
}