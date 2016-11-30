package jnorbury.jonahnorbury_pset5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);
    }

    public void addListofTypeRadio(View view) {
        RadioGroup rg = (RadioGroup) findViewById(R.id.listsRadioGroup);
        RadioButton rbtn = (RadioButton) rg.findViewById(rg.getCheckedRadioButtonId());
        int idx = rg.indexOfChild(rbtn);

        String w = rbtn.getText().toString();
//        Toast.makeText(this, "idx " + idx + ". : " + w, Toast.LENGTH_SHORT).show();

        if (w.equals("Groceries")) {
            // make new grocerylist
            GroceryList gl = new GroceryList();
            ToDoManager.getInstance().addList(gl);
//            Toast.makeText(this, "added gl: " + gl.size(), Toast.LENGTH_SHORT).show();

        } else if (w.equals("Homework")) {
            // make new homeworklist
        }
        Toast.makeText(this, "no of lists: " + ToDoManager.getlist().size(), Toast.LENGTH_SHORT).show();

        finish();
    }
}
