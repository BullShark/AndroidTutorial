package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Christopher Lemire 9/30/2014.
 */
public class Slider extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sliding);
  }
}
