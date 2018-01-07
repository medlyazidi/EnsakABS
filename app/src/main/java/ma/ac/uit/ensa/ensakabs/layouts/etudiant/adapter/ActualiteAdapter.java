package ma.ac.uit.ensa.ensakabs.layouts.etudiant.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import ma.ac.uit.ensa.ensakabs.R;


public class ActualiteAdapter extends ArrayAdapter<ActualiteObjects> {
    private ArrayList<ActualiteObjects> ComplexObjects_Array;
    private Context context;
    static ActualiteObjects myComplexObjects;
    private int resource;


    public ActualiteAdapter(Context context, ArrayList<ActualiteObjects> ComplexObjects_Array)
    {
        super(context, 0,ComplexObjects_Array);

    }

    @Override
    public View getView(int position, View ConvertView, ViewGroup parent)
    {


        if (ConvertView == null)
        {
            ConvertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_actualite_etudiant, parent, false);

            myComplexObjects = new ActualiteObjects(null, null, null);

            myComplexObjects.linearLayout = (LinearLayout) ConvertView.findViewById(R.id.activityAdapterLinearLayout);
            myComplexObjects.myImage = (ImageView) ConvertView.findViewById(R.id.imageView);
            myComplexObjects.myTextView = (TextView) ConvertView.findViewById(R.id.textView);

            ConvertView.setTag(myComplexObjects);
        }
        else
        {
            myComplexObjects = (ActualiteObjects) ConvertView.getTag();
            ConvertView.setTag(myComplexObjects);
        }
        return ConvertView;
    }

    public static void changeImage()
    {

        myComplexObjects.myImage.setImageResource(R.drawable.pink_circle);
    }
}
