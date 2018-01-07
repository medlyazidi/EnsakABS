package ma.ac.uit.ensa.ensakabs.layouts.etudiant.screen.etudiant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import ma.ac.uit.ensa.ensakabs.R;
import ma.ac.uit.ensa.ensakabs.layouts.etudiant.presentation.ConnectServer;
import ma.ac.uit.ensa.ensakabs.layouts.etudiant.presentation.SocketHandler;

public class SignIn extends AppCompatActivity {

    Button loginButton;
    EditText usernameField;
    private Socket mSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ConnectServer server = new ConnectServer();
        mSocket = server.getSocket();
        mSocket.connect();
        SocketHandler.setSocket(mSocket);

        Log.d("SocketID",mSocket.toString());


        loginButton = (Button) findViewById(R.id.loginButton);
        usernameField = (EditText) findViewById(R.id.editTextUsername);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("textSimo",usernameField.getText().toString().trim());
                try {
                    JSONObject jObj = new JSONObject();
                    String text = usernameField.getText().toString().trim();
                    jObj.put("userName", text);

                    mSocket.emit("login",jObj);
                } catch (Exception e) {
                    Log.e("MYAPP", "unexpected JSON exception", e);
                }



                    //Intent intent = new Intent(getApplicationContext(), ListeAnnee.class);
                    //startActivity(intent);

            }
        });
        mSocket.on("login", onLogin);

    }

    private Emitter.Listener onLogin = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    String rows;
                    String role;
                    try {

                        rows = data.getString("rows");
                        role = data.getString("role");
                        Log.d("rowsrows",data.toString());
                        usernameField.setText(rows);
                    } catch (JSONException e) {
                        return;
                    }
                }
            });
        }
    };


}

