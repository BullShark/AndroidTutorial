package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SlidingDrawer;

/**
 * Created by Christopher Lemire 9/30/2014.
 */

public class Slider extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SlidingDrawer.OnDrawerOpenListener {

  private SlidingDrawer sd;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sliding);
    Button handle0 = (Button) findViewById(R.id.handle0);
    Button button1 = (Button) findViewById(R.id.button1);
    Button button2 = (Button) findViewById(R.id.button2);
    Button button3 = (Button) findViewById(R.id.button3);
    Button button4 = (Button) findViewById(R.id.button4);
    CheckBox checkbox = (CheckBox) findViewById(R.id.cb_slidable);
    sd = (SlidingDrawer) findViewById(R.id.d_sliding);
    sd.setOnDrawerOpenListener(this);
  }

  @Override
  public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
  if(isChecked) {
      sd.lock();
    } else {
      sd.unlock();
    }
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.button1:
        sd.open();
        break;
      case R.id.button2:
        break;
      case R.id.button3:
         sd.toggle();
         break;
      case R.id.button4:
        sd.close();
        break;
    }
  }

  @Override
  public void onDrawerOpened() {
    MediaPlayer mp = MediaPlayer.create(this, R.raw.grenade);
    mp.start();
  }
}
