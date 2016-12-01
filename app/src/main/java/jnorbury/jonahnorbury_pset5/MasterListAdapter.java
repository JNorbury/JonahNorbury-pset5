package jnorbury.jonahnorbury_pset5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by jonah on 01-Dec-16.
 */

public class MasterListAdapter extends ArrayAdapter<ToDoList> {
    private ArrayList<ToDoList> masterlist;
    public MasterListAdapter(Context context, int textViewResourceId,
                             ArrayList<ToDoList> masterlist) {
        super(context, textViewResourceId, masterlist);
        this.masterlist = masterlist;
    }
    @Override

    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.master_list_item_layout, null);
        }
        if (masterlist.size() == 0) {
            return null;
        }
        ToDoList list = masterlist.get(position);
        if (list != null) {
            TextView name = (TextView) v.findViewById(R.id.listNameTextView);
            TextView size = (TextView) v.findViewById(R.id.listSizeTextView);
            if (name != null) {
                name.setText(list.getList_name());
            }
            if (size != null) {

                size.setText("size: " + list.size());
            }
        }
        return v;
    }
}
