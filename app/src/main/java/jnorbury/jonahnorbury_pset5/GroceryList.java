package jnorbury.jonahnorbury_pset5;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import static android.R.attr.id;

/**
 * Created by jonah on 30-Nov-16.
 */

public class GroceryList<GroceryItem> extends ToDoList {

    public ArrayAdapter getAdapter(Context context) {
        return new GroceryItemAdapter(context, R.layout.grocery_list_item_layout, this);
    }

    public GroceryList(String list_name) {
        super.setList_name(list_name);
    }

}
