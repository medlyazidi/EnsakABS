package ma.ac.uit.ensa.ensakabs.layouts.etudiant.screen.etudiant;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import ma.ac.uit.ensa.ensakabs.R;

public class UploadJustificationEtudiant extends NavigationDrawerEtudiant {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_upload_justification_etudiant, null, false);
        drawer.addView(contentView, 0);

    }
}
