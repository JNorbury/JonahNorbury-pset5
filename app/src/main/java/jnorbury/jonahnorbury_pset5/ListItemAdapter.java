package jnorbury.jonahnorbury_pset5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Norbury on 29-Nov-16.
 */

public class ListItemAdapter extends ArrayAdapter<TodoItem>{
    private ArrayList<TodoItem> todos;
    public ListItemAdapter(Context context, int textViewResourceId,
       ArrayList<TodoItem> todos) {
        super(context, textViewResourceId, todos);
        this.todos = todos;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout., null)
        }
        TodoItem item = todos.get(position);
        if (item != null) {
            TextView username = (TextView) v.findViewById(R.id.username);
            TextView email = (TextView) v.findViewById(R.id.email);
            if (username != null) {
                username.setText(item.getTitle());
            }
            if(email != null) {
                email.setText(item.getDescription() );
            }
        }
        return v;
    }
}
