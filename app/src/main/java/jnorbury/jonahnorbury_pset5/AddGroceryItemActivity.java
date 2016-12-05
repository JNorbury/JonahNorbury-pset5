package jnorbury.jonahnorbury_pset5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddGroceryItemActivity extends AppCompatActivity {

    public ToDoListManager mlm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grocery_item);
    }


    public void saveNewItemData(View view) {
        EditText et = (EditText) findViewById(R.id.NewItemNameET);
        String newname = et.getText().toString();

        String etw = findViewById(R.id.newWeightET).toString();

        if (newname.matches("") || etw.isEmpty() || etw == null) {
            Toast.makeText(this, "No name given", Toast.LENGTH_SHORT).show();
        } else {
            Double etwd = Double.parseDouble(etw);
            GroceryItem newitem = new GroceryItem(newname, etwd);





        }
    }
}
