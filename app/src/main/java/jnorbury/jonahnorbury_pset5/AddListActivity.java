package jnorbury.jonahnorbury_pset5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
        EditText nameET = (EditText) findViewById(R.id.nameListET);
        String newname = nameET.getText().toString();
        rg = (RadioGroup) findViewById(R.id.listsRadioGroup);
        int cid = rg.getCheckedRadioButtonId();
        View rview = rg.findViewById(cid);
        rbtn = (RadioButton) rview;

        // check whether no button is clicked or not name given, else create list and finish activity
        if (rbtn == null || newname.matches("")) {
            Toast.makeText(this, "no list given, doofus", Toast.LENGTH_SHORT).show();
        } else {
            ltype = rbtn.getText().toString();
            if (ltype.equals("Groceries")) {
                GroceryList list = new GroceryList(newname);
            } else if (ltype.equals("Homework")) {
                HomeworkList list = new HomeworkList(newname);
            }
            ToDoListManager.getInstance().addList(list);
            finish();
        }
    }
}
