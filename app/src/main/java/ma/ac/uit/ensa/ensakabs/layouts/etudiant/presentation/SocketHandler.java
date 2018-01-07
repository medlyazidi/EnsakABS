package ma.ac.uit.ensa.ensakabs.layouts.etudiant.presentation;

import io.socket.client.Socket;
//import com.github.nkzawa.socketio.client.Socket;


public class SocketHandler {
    private static Socket socket;

    public static synchronized Socket getSocket(){
        return socket;
    }

    public static synchronized void setSocket(Socket socket){
        SocketHandler.socket = socket;
    }
}
