package ma.ac.uit.ensa.ensakabs.layouts.etudiant.screen.etudiant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import ma.ac.uit.ensa.ensakabs.R;
import ma.ac.uit.ensa.ensakabs.layouts.etudiant.adapter.CustomActuAdapter;

public class ActualitesEtudiant extends NavigationDrawerEtudiant {
    ListView list;
    String[] itemname ={
            "Absence à justifier",
            "Justification acceptée",
            "Nouvelle séance de rattrapage programmée le 17/09/2017",
            "Justification refusée",
            "Absence à justifier",

            "Vous avez un avertissement",
            "M. xyz sera absent le 02/04/2017",
            "Justification acceptée",
            "Nouvelle séance de rattrapage"
    };

    String[] itemdesc ={
            "Vous avez une absence en attente de justification",
            "Votre justification d'absence du 26/10/2017 a été acceptée",
            "Cliquez pour contester/accepter",
            "Votre justification d'absence du 30/05/2017 a été refusée",
            "Vous avez une absence en attente de justification",

            "Votre taux d'absentéisme a dépassé 20%",
            "Une séance de rattrapage sera bientôt programmée",
            "Votre justification d'absence du 26/09/2017 a été acceptée",
            "Une séance de rattrapage à été programmée le 04/02/2017"
    };

    Integer[] imgid={
            R.drawable.just_en_cours,
            R.drawable.justaccepted,
            R.drawable.rattscheduled,
            R.drawable.absencenonj,
            R.drawable.just_en_cours,
            R.drawable.avertissment,
            R.drawable.info,
            R.drawable.justaccepted,
            R.drawable.rattscheduled,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_actualites_etudiant, null, false);
        drawer.addView(contentView, 0);




        CustomActuAdapter adapter=new CustomActuAdapter(this, itemname, imgid, itemdesc);
        list=(ListView)findViewById(R.id.listactu);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
               //TODO
                // Must be displayed only when "contester" is pressed 
                String title = getString(R.string.contester);
                String message = getString(R.string.dialog_contester);
                DialogBoxContesterEtudiant dialog = new DialogBoxContesterEtudiant();
                Bundle args = new Bundle();
                args.putString(DialogBoxContesterEtudiant.ARG_TITLE, title);
                args.putString(DialogBoxContesterEtudiant.ARG_MESSAGE, message);
                dialog.setArguments(args);

                dialog.show(getFragmentManager(), "tag");
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(getApplicationContext(), SignIn.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }




}
