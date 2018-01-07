package ma.ac.uit.ensa.ensakabs.layouts.etudiant.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import ma.ac.uit.ensa.ensakabs.R;
import ma.ac.uit.ensa.ensakabs.layouts.etudiant.model.Student;

public class CustomListActivity extends BaseAdapter {

    Context context;
    private List<Student> rowItem;
    View listView;
    boolean checkState[];
    ViewHolder holder;
    SparseBooleanArray mCheckStates;

    public CustomListActivity(Context context, List<Student> rowItem) {

        this.context = context;
        this.rowItem = rowItem;
        checkState = new boolean[rowItem.size()];
        mCheckStates = new SparseBooleanArray();

    }

    @Override
    public int getCount() {

        return rowItem.size();
    }

    @Override
    public Object getItem(int position) {

        return rowItem.get(position);

    }

    @Override
    public long getItemId(int position) {

        return rowItem.indexOf(getItem(position));

    }

    public class ViewHolder {
        TextView tvItemName;
        CheckBox check;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        holder = new ViewHolder();
        final Student itm = rowItem.get(position);
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (view == null) {

            listView = new View(context);
            listView = layoutInflater.inflate(R.layout.layout_item_etudiant,
                    parent, false);

            holder.tvItemName = (TextView) listView
                    .findViewById(R.id.title);
            holder.check = (CheckBox) listView.findViewById(R.id.checkbox_item);
            listView.setTag(holder);

        } else {
            listView = (View) view;
            holder = (ViewHolder) listView.getTag();
        }

        holder.tvItemName.setText(itm.getItems());

        holder.check.setChecked(checkState[position]);

        holder.check.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {



            }
        });
        return listView;
    }}
