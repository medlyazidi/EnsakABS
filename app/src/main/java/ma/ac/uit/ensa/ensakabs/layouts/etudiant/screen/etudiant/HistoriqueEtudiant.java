package ma.ac.uit.ensa.ensakabs.layouts.etudiant.screen.etudiant;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ListView;

import com.roomorama.caldroid.CaldroidFragment;

import java.util.Calendar;
import java.util.Date;

import ma.ac.uit.ensa.ensakabs.R;

public class HistoriqueEtudiant extends NavigationDrawerEtudiant {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_historique_etudiant, null, false);
        drawer.addView(contentView, 0);



        ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.mainThemeColorForButtons));
        ColorDrawable yellow = new ColorDrawable(getResources().getColor(R.color.calendarYellowColor));
        ColorDrawable pink = new ColorDrawable(getResources().getColor(R.color.colorAccent));


        CaldroidFragment caldroidFragment = new CaldroidFragment();
        Bundle args = new Bundle();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date testDate = cal.getTime();

        cal.add(Calendar.DATE, -3);
        Date testDate2 = cal.getTime();

        cal.add(Calendar.DATE, +5);
        Date testDate3 = cal.getTime();

        args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
        caldroidFragment.setArguments(args);

        //To change the background color of a specific date :
        caldroidFragment.setBackgroundDrawableForDate(blue, testDate);
        caldroidFragment.setBackgroundDrawableForDate(yellow, testDate2);
        caldroidFragment.setBackgroundDrawableForDate(pink, testDate3);

        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.historiqueEtudiantC, caldroidFragment);
        t.commit();

    }


}
