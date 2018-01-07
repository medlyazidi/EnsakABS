package ma.ac.uit.ensa.ensakabs.layouts.etudiant.screen.prof;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import ma.ac.uit.ensa.ensakabs.R;
import ma.ac.uit.ensa.ensakabs.layouts.etudiant.adapter.CustomActuAdapter;
import ma.ac.uit.ensa.ensakabs.layouts.etudiant.screen.etudiant.DialogBoxContesterEtudiant;
import ma.ac.uit.ensa.ensakabs.layouts.etudiant.screen.etudiant.NavigationDrawerEtudiant;


public class ListFiliere extends NavigationDrawerEtudiant {
    ListView list;
    String[] itemname ={
            "Génie Informatique",
            "Cycle Logiciel",
            "Cycle Reseau",
            "Cycle Mecanique",
            "Cycle Electrique"
    };

    String[] itemdesc ={
            "", "", "","",""
    };

    Integer[] imgid={
            R.drawable.classe,
            R.drawable.classe,
            R.drawable.classe,
            R.drawable.classe,
            R.drawable.classe,
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






}
