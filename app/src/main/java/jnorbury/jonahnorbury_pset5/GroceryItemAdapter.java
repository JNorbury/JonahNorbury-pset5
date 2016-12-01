package jnorbury.jonahnorbury_pset5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Norbury on 29-Nov-16.
 */

// create itemadapter for grocery items
public class GroceryItemAdapter extends ArrayAdapter<GroceryItem>{
    private ArrayList<GroceryItem> groceries;
    public GroceryItemAdapter(Context context, int textViewResourceId,
                              GroceryList groceries) {
        super(context, textViewResourceId, groceries);
        this.groceries = groceries;
    }
    @Override

    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.grocery_list_item_layout, null);
        }
        GroceryItem item = groceries.get(position);
        if (item != null) {
            TextView name = (TextView) v.findViewById(R.id.task_name);
            CheckBox completed = (CheckBox) v.findViewById(R.id.completedgrocery);
            if (name != null) {
                name.setText(item.getName());
            } else if(completed != null) {
                completed.setChecked(item.getCompleted());
            }
        }
        return v;
    }
}
