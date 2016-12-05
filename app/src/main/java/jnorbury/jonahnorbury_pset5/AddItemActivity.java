package jnorbury.jonahnorbury_pset5;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }


    public void saveNewItemData(View view) {
        EditText et = (EditText) findViewById(R.id.NewItemNameET);
        String newname = et.getText().toString();
        if (newname.matches("")) {
            Toast.makeText(this, "No name given", Toast.LENGTH_SHORT).show();
        } else {
            TodoItem newitem = new TodoItem(newname);

        }


        // already call sequel?

    }
}
