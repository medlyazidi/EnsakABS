package ma.ac.uit.ensa.ensakabs.layouts.etudiant.screen.etudiant;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import ma.ac.uit.ensa.ensakabs.R;
import ma.ac.uit.ensa.ensakabs.layouts.etudiant.adapter.CustomActuAdapter;

/*
        The list of absences that need to be justified
 */

public class AbsenceAJustifEtudiant extends NavigationDrawerEtudiant {

    ListView list;

    // will be filled from db
    // The items in bold style
    String[] itemname ={
            "Absence à justifier",
            "Absence à justifier",
            "Absence à justifier"
    };

    //items description
    String[] itemdesc ={
            "17/05/2017 - Séance de management",
            "17/06/2016 - Séance d'algèbre",
            "17/03/2017 - Séance d'analyse"
    };

    // items icon
    Integer[] imgid={
            R.drawable.just_en_cours,
            R.drawable.just_en_cours,
            R.drawable.just_en_cours,

    };

    public static final String PREFS_NAME = "checkValidPref";
    public CheckBox neplusafficher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_absence_ajustif_etudiant, null, false);
        drawer.addView(contentView, 0);

        CustomActuAdapter adapter=new CustomActuAdapter(this, itemname, imgid, itemdesc);
        list=(ListView)findViewById(R.id.justEtudList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), UploadJustificationEtudiant.class);
                startActivity(intent);

            }
        });

        // Alert dialog
        AlertDialog.Builder adb = new AlertDialog.Builder(AbsenceAJustifEtudiant.this);
        LayoutInflater adbInflater = LayoutInflater.from(AbsenceAJustifEtudiant.this);
        View eulaLayout = adbInflater.inflate(R.layout.checkbox_popup_justif_etudiant, null);
        neplusafficher = (CheckBox) eulaLayout.findViewById(R.id.skip);
        adb.setView(eulaLayout);

        adb.setTitle("Attention");
        adb.setMessage(R.string.justif_absence_dialog);
        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String checkBoxResult = "NOT checked";
                if (neplusafficher.isChecked())
                    checkBoxResult = "checked";
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("skipMessage", checkBoxResult);
                editor.commit();
            }
        });

        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String checkBoxResult = "NOT checked";
                if (neplusafficher.isChecked())
                    checkBoxResult = "checked";
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("skipMessage", checkBoxResult);
                editor.commit();
            }
        });
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String skipMessage = settings.getString("skipMessage", "NOT checked");
        if (!skipMessage.equals("checked"))
            adb.show();

    }


}
