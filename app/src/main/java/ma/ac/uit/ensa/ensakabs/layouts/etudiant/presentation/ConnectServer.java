package ma.ac.uit.ensa.ensakabs.layouts.etudiant.presentation;


import android.util.Log;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;


public class ConnectServer {
    private Socket mSocket;
    {
        try {
            //mSocket = IO.socket("http://192.168.1.8:3000");
            mSocket = IO.socket("http://10.0.2.2:3000");
        } catch (URISyntaxException e) {


            Log.e("URLSocket", "can nnot connect to sorver");
            Log.e("ExceptionServer", e.toString());
        }
    }
    public Socket getSocket(){
        return mSocket;
    }
}
