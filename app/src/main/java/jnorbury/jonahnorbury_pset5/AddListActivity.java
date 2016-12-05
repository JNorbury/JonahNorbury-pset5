package jnorbury.jonahnorbury_pset5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddListActivity extends AppCompatActivity {

    private RadioButton rbtn;
    private RadioGroup rg;
    private String ltype;
    private ToDoList list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);
    }

    // allow user to select type of list to add
    public void addListofTypeRadio(View view) {
        rg = (RadioGroup) findViewById(R.id.listsRadioGroup);
        int cid = rg.getCheckedRadioButtonId();
        View rview = rg.findViewById(cid);
        rbtn = (RadioButton) rg.getChildAt(cid);
        if (rbtn == null) { // check whether no button is clicked
            Toast.makeText(this, "no list given, doofus", Toast.LENGTH_SHORT).show();
        } else { //else grab ltype string
            ltype = rbtn.getText().toString();

            // check what type of list is added and create list of type
            if (ltype.equals("Groceries")) {
                GroceryList list = new GroceryList("grocerylist2");
                ToDoListManager.getInstance().addList(list);
            } else if (ltype.equals("Homework")) {
                HomeworkList list = new HomeworkList("hwlist2");
                ToDoListManager.getInstance().addList(list);
            }
            finish();
        }
    }
}
