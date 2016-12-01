package jnorbury.jonahnorbury_pset5;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by jonah on 01-Dec-16.
 */

public class HomeworkList<HomeworkItem> extends ToDoList {
    public HomeworkList(String s) {
        super(s);
    }

    public ArrayAdapter getAdapter(Context context) {
        return new HomeworkItemAdapter(context, R.layout.homework_list_item_layout, this);
    }
}
