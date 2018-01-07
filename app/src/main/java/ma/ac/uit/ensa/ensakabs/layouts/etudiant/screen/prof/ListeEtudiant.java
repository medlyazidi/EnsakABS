package ma.ac.uit.ensa.ensakabs.layouts.etudiant.screen.prof;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ma.ac.uit.ensa.ensakabs.R;
import ma.ac.uit.ensa.ensakabs.layouts.etudiant.adapter.CustomListActivity;
import ma.ac.uit.ensa.ensakabs.layouts.etudiant.model.Student;

public class ListeEtudiant extends NavigationDrawerProf {

    String[] ItemName;
    List<Student> rowItem;

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_liste_etudiant);

        rowItem = new ArrayList<Student>();
        ItemName = getResources().getStringArray(R.array.name);
        //ItemName = new String[]{"Karim", "Ahmed", "samla"};

        for (int i = 0; i < ItemName.length; i++) {
            Student itm = new Student(ItemName[i]);
            rowItem.add(itm);
        }

        list = (ListView) findViewById(R.id.liste_etudiant_appel);

        final CustomListActivity adapter = new CustomListActivity(this, rowItem);
        list.setAdapter(adapter);

        final Button button = findViewById(R.id.appelButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // coucou lyazidi tu met ici les methodes definis dans l'adapter pour avoir les items , bisous

            }
        });
    }


}
