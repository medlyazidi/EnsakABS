package ma.ac.uit.ensa.ensakabs.layouts.etudiant.screen.prof;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import ma.ac.uit.ensa.ensakabs.R;
import ma.ac.uit.ensa.ensakabs.layouts.etudiant.adapter.CustomActuAdapter;


public class ListeAnnee extends NavigationDrawerProf{
    ListView list;
    String[] itemname ={
            "Cycle Preparatoire 1",
            "Cycle Preparatoire 2",
            "Cycle Ingénieur 1",
            "Cycle Ingénieur 2",
            "Cycle Ingénieur 3",
            "Cycle Master 1",
            "Cycle Master 2"
    };

    String[] itemdesc ={
            "", "", "","","" ,"", ""
    };

    Integer[] imgid={
            R.drawable.profil,
            R.drawable.profil,
            R.drawable.profil,
            R.drawable.profil,
            R.drawable.profil,
            R.drawable.profil,
            R.drawable.profil
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
                Intent intent;
                switch (position){
                    case 0 :
                        intent = new Intent(ListeAnnee.this, ListSectionCP.class);
                        startActivity(intent);
                        break;
                    case 1 :
                        intent = new Intent(ListeAnnee.this, ListSectionCP.class);
                        startActivity(intent);
                        break;
                    case 2 :
                        intent = new Intent(ListeAnnee.this, ListFiliere.class);
                        startActivity(intent);
                        break;
                    case 3 :
                        intent = new Intent(ListeAnnee.this, ListFiliere.class);
                        startActivity(intent);
                        break;
                    case 4 :
                        intent = new Intent(ListeAnnee.this, ListFiliere.class);
                        startActivity(intent);
                        break;
                    case 5 :
                        intent = new Intent(ListeAnnee.this, ListFiliere.class);
                        startActivity(intent);
                        break;
                    case 6 :
                        intent = new Intent(ListeAnnee.this, ListFiliere.class);
                        startActivity(intent);
                        break;
                    case 7 :
                        intent = new Intent(ListeAnnee.this, ListFiliere.class);
                        startActivity(intent);
                        break;

                }


            }
        });
    }






}
