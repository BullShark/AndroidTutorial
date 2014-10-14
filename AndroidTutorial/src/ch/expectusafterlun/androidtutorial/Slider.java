package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by Christopher Lemire 9/30/2014.
 */
public class Slider extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sliding);
    Button handle0 = (Button) findViewById(R.id.handle0);
    Button handle1 = (Button) findViewById(R.id.handle1);
    Button handle2 = (Button) findViewById(R.id.handle2);
    Button handle3 = (Button) findViewById(R.id.handle3);
    Button handle4 = (Button) findViewById(R.id.handle4);
    CheckBox checkbox = (CheckBox) findViewById(R.id.cb_slidable);
  }
}
