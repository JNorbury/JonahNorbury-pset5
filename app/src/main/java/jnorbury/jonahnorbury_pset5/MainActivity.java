package jnorbury.jonahnorbury_pset5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private ToDoListManager manager;
    private MasterListAdapter mla;
    private MasterList masterList;
    private ArrayAdapter aa;
    private ToDoList current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        manager = ToDoListManager.getInstance();

        GroceryList groceryList = new GroceryList("jerry1");
        groceryList.add(new GroceryItem("bananas", 1.5));
        groceryList.add(new GroceryItem("eggs", 12));
        groceryList.add(new GroceryItem("pancake mix", 0.75));
        groceryList.add(new GroceryItem("milk", 4));
        groceryList.add(new GroceryItem("beb: true!", 0.5));

        HomeworkList homeworkList = new HomeworkList("jonah1");
        homeworkList.add(new HomeworkItem("assignment 1", "21-12-2016"));
        homeworkList.add(new HomeworkItem("test 1", "21-11-2016"));
        homeworkList.add(new HomeworkItem("seminar", "21-2-2016"));
        homeworkList.add(new HomeworkItem("assignment 2", "1-12-2002"));
        homeworkList.add(new HomeworkItem("assignment 1", "21-12-2016"));
        homeworkList.add(new HomeworkItem("test 1", "21-11-2016"));
        homeworkList.add(new HomeworkItem("seminar", "21-2-2016"));
        homeworkList.add(new HomeworkItem("assignment 2", "1-12-2002"));
        homeworkList.add(new HomeworkItem("assignment 1", "21-12-2016"));
        homeworkList.add(new HomeworkItem("test 1", "21-11-2016"));
        homeworkList.add(new HomeworkItem("seminar", "21-2-2016"));
        homeworkList.add(new HomeworkItem("assignment 2", "1-12-2002"));

        masterList = new MasterList();
        masterList.add(groceryList);
        masterList.add(homeworkList);
    }


    @Override
    protected void onResume() {
        super.onResume();
        fixLists();

    }

    private void fixLists() {
        ListView llv = (ListView) findViewById(R.id.listsListView);
        mla = new MasterListAdapter(this, android.R.layout.simple_list_item_1, masterList);
        llv.setAdapter(mla);

        // on click for masterlist
        llv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                current = mla.getItem(position);
                TextView titlehome = (TextView) findViewById(R.id.masterTitleTextView);
                titlehome.setText("Current list: " + current.getList_name());

            ListView glv = (ListView) findViewById(R.id.genericListView);

            aa = current.getAdapter(getBaseContext());
            glv.setAdapter(aa);
            aa.notifyDataSetChanged();
            }
        });

//        ListView glv = (ListView) findViewById(R.id.genericListView);
//        ToDoList test = masterList.get(1);
//        ArrayAdapter aa = test.getAdapter(this);
//        glv.setAdapter(aa);
//        aa.notifyDataSetChanged();

//        ArrayList<ToDoList> list = ToDoListManager.getAllLists();
    }

    public void makeNewList(View view) {
        Intent intent = new Intent(this, AddListActivity.class);
        startActivity(intent);

    }

    public void addNewItem(View view) {
//        Intent intent = new Intent(this, )
        Intent intent = new Intent(this, AddGroceryItemActivity.class);
        intent.putExtra("listname", current.getList_name());
    }

    public void onCheckBoxClicked(View view) {
        CheckBox cb = (CheckBox) view;
        TodoItem item = current.get((int) cb.getTag());

        if (cb.isChecked()) {
            item.setCompleted(true);
            Toast.makeText(this, "finished " + item.getName() + " !", Toast.LENGTH_SHORT).show();
        } else {
            item.setCompleted(false);
            Toast.makeText(this, "didn't finish " + item.getName() + " anyway?", Toast.LENGTH_SHORT).show();
        }

    }
}
