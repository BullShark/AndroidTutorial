package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
                boolean success = true;
                try {
                    String name = sqlName.getText().toString();
                    String hotness = sqlHotness.getText().toString();

                    HotOrNot entry = new HotOrNot(SQLiteExample.this);
                    entry.open();
                    entry.createEntry(name, hotness);
                    entry.close();
                } catch (Exception ex) {
                    success = false;
                    String error = ex.toString();
                    Dialog d = new Dialog(this);
                    d.setTitle("Dang it!");
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                } finally {
                    if(success) {
                        Dialog d = new Dialog(this);
                        d.setTitle("Heck Yeah!");
                        TextView tv = new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }
                }
                break;
            case R.id.b_sql_open_view:
                Intent i = new Intent("android.intent.action.SQLVIEW");
                startActivity(i);
                break;
        }
    }
}