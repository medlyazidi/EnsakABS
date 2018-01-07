package ma.ac.uit.ensa.ensakabs.layouts.etudiant.screen.etudiant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import ma.ac.uit.ensa.ensakabs.R;

public class UploadJustificationEtudiant extends NavigationDrawerEtudiant {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_upload_justification_etudiant, null, false);
        drawer.addView(contentView, 0);

        ImageButton attachJustifButton = (ImageButton) findViewById(R.id.attachJustifButton);
        Button sendJustButton = (Button) findViewById(R.id.sendJustButton);

         attachJustifButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                /*
                GetImageUrl getImageUrl = new GetImageUrl();
                getImageUrl.url = "http://10.0.2.2:3000/images/image.jpg";
                getImageUrl.execute();
                */
                 selectImage();
             }
         });

         sendJustButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                Intent intent = new Intent(UploadJustificationEtudiant.this, ActualitesEtudiant.class);
                startActivity(intent);
             }
         });



    }

    private void selectImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode == RESULT_OK && data != null){
            Toast.makeText(UploadJustificationEtudiant.this, "Votre Fichier est bien preparé pour l'envoie.", Toast.LENGTH_LONG).show();
        }
    }
}
