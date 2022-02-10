package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;

import android.os.Bundle;

public class Allison extends AppCompatActivity {

    @SuppressLint({"ResourceType", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout
        RelativeLayout rl = new RelativeLayout(this);
        Button redButton = new Button(this);
        EditText etUserName = new EditText(this);

        // Set the IDs before calling View.getId()
        redButton.setId(1);
        etUserName.setId(2);

        // Rules
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        RelativeLayout.LayoutParams userNameDetails = new RelativeLayout.LayoutParams(
                //RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        userNameDetails.addRule(RelativeLayout.ABOVE, redButton.getId());
        userNameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        userNameDetails.setMargins(0,0,0, 50);

        // Convert density pixels (dp) to pixels
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                200,
                r.getDisplayMetrics());

        // Attributes
        etUserName.setWidth(px);
        redButton.setText("Log In");
        rl.setBackgroundColor(Color.GREEN);
        redButton.setBackgroundColor(Color.RED);

        // Add widget to layout
        rl.addView(redButton, buttonDetails);
        rl.addView(etUserName, userNameDetails);

        // Set this Activities content(display) to this View
        setContentView(rl);
    }

    //@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //super.onCreateOptionsMenu(menu);
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cool_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}