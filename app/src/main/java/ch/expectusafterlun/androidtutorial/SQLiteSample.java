package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SQLiteSample extends Activity {

    private EditText et;
    private TextView tv;
    private MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_sample);

        et = findViewById(R.id.buckys_input);
        tv = findViewById(R.id.buckys_text);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }

    // Set the TextView to show the text from MyDBHandler.toString()
    public void printDatabase() {
        tv.setText(dbHandler.toString());
        et.setText("");
    }

    public void addButtonClicked(View view) {
        dbHandler.addProduct(new Products(et.getText().toString()));
        printDatabase();
        et.setText("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHandler.close();
    }

    public void deleteButtonClicked(View view) {
        dbHandler.deleteProduct(et.getText().toString());
        printDatabase();
        et.setText("");
    }
}