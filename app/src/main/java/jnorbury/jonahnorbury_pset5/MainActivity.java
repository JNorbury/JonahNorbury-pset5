package jnorbury.jonahnorbury_pset5;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private ToDoListManager manager;
    private MasterListAdapter mla;
    private MasterList masterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_main_layout);
        manager = ToDoListManager.getInstance();

        GroceryList groceryList = new GroceryList("grocery1");
        groceryList.add(new GroceryItem("bananas", 1.5));
        groceryList.add(new GroceryItem("eggs", 12));
        groceryList.add(new GroceryItem("pancake mix", 0.75));
        groceryList.add(new GroceryItem("milk", 4));

        GroceryItem itemnew = new GroceryItem("beb: true!", 0.5);
        itemnew.setCompleted(Boolean.TRUE);
        groceryList.add(itemnew);

        HomeworkList homeworkList = new HomeworkList("homework1");
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
        // do shit to make lists appear in listview
        ListView llv = (ListView) findViewById(R.id.listsListView);
        mla = new MasterListAdapter(this, android.R.layout.simple_list_item_1, masterList);
        llv.setAdapter(mla);

        ListView glv = (ListView) findViewById(R.id.genericListView);
        ToDoList test = masterList.get(1);
        // this is where we call the smart adapter
//        ArrayAdapter aa = test;
        glv.setAdapter(aa);

//        ArrayList<ToDoList> list = ToDoListManager.getAllLists();
    }

    public void makeNewList(View view) {
        Intent intent = new Intent(this, AddListActivity.class);
        startActivity(intent);

    }

    public void addNewItem(View view) {
//        Intent intent = new Intent(this, )
    }
}
