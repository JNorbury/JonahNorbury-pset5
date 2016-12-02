package jnorbury.jonahnorbury_pset5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Norbury on 29-Nov-16.
 */

// create itemadapter for grocery items
public class HomeworkItemAdapter extends ArrayAdapter<HomeworkItem>{
    private ArrayList<HomeworkItem> assignments;
    public HomeworkItemAdapter(Context context, int textViewResourceId,
                              HomeworkList assignments) {
        super(context, textViewResourceId, assignments);
        this.assignments = assignments;
    }
    @Override

    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.homework_list_item_layout, null);
        }
        HomeworkItem item = assignments.get(position);
        if (item != null) {

            TextView name = (TextView) v.findViewById(R.id.text_view_task_name);
            if (name != null) {
                name.setText(item.getName());
            }

            CheckBox checkBox = (CheckBox) v.findViewById(R.id.completedhomework);
            if(checkBox != null) {
                checkBox.setChecked(item.getCompleted());
                checkBox.setTag(position);
            }

            TextView duedate = (TextView) v.findViewById(R.id.text_view_due_date);
            if (duedate != null) {
                duedate.setText(item.getDue_date());
            }
        }
        return v;
    }
}
