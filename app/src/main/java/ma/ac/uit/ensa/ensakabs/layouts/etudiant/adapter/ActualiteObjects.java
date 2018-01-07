package ma.ac.uit.ensa.ensakabs.layouts.etudiant.adapter;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ouissal on 11/22/17.
 */

public class ActualiteObjects {
    //Button myButton;
    ImageView myImage;
    TextView myTextView;

    LinearLayout linearLayout;

    public ActualiteObjects(ImageView myImage, TextView myTextView, LinearLayout linearLayout) {
        this.myImage =myImage ;
        this.myTextView = myTextView;
        this.linearLayout = linearLayout;

    }



    public void setImage(ImageView myImage)
    {
        this.myImage = myImage;
    }
    public void setTextView (TextView myTextView)
    {
        this.myTextView = myTextView;
    }

    public void setLinearLayout (LinearLayout linearLayout)
    {
        this.linearLayout = linearLayout;
    }

    public ImageView getImage()
    {
        return myImage;
    }
    public TextView getTextView ()
    {
        return myTextView;
    }

    public LinearLayout getLinearLayout (LinearLayout linearLayout)
    {
        return linearLayout;
    }

}
