package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SQLiteExample extends AppCompatActivity implements View.OnClickListener {

    private Button sqlUpdate, sqlView;
    private EditText sqlName, sqlHotness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqliteexample);

        sqlUpdate = (Button) findViewById(R.id.b_sql_update);
        sqlName = (EditText) findViewById(R.id.et_sql_name);
        sqlHotness = (EditText) findViewById(R.id.et_sql_hotness);
        sqlView = (Button) findViewById(R.id.b_sql_open_view);

        sqlView.setOnClickListener(this);
        sqlUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_sql_update:
                String name = sqlName.getText().toString();
                String hotness = sqlHotness.getText().toString();

                HotOrNot entry = new HotOrNot(SQLiteExample.this);
                entry.open();
                entry.createEntry(name, hotness);
                entry.close();
                break;
            case R.id.b_sql_open_view:

                break;
        }
    }
}