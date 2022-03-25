package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

public class Overflow extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overflow);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater blowUp = getMenuInflater();
        blowUp.inflate(R.menu.menu_overflow, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // return super.onOptionsItemSelected(item);
        ConstraintLayout mainView = findViewById(R.id.main_view);
        switch (item.getItemId()) {
            case R.id.menu_red:
                item.setChecked(!item.isChecked());
                mainView.setBackgroundColor(Color.RED);
                return true;
            case R.id.menu_green:
                item.setChecked(!item.isChecked());
                mainView.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.menu_yellow:
                item.setChecked(!item.isChecked());
                mainView.setBackgroundColor(Color.YELLOW);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}