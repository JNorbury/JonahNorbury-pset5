package jnorbury.jonahnorbury_pset5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    NotUsefulStringManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void setUsefulString(View view) {

        EditText et = (EditText) findViewById(R.id.editText);
        manager = NotUsefulStringManager.getInstance();
        manager.setSuperUsefulString(et.getText().toString());

    }
}
