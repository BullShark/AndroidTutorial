package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Christopher Lemire on 9/23/2014.
 */
public class SoundStuff extends Activity implements View.OnClickListener {
  // SoundPool is for shorter sounds/audio clips as
  // Opposed to MediaPlayer for longer sounds
  SoundPool sp;
  int explosion = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    View view = new View(this);
    view.setOnClickListener(this);
    setContentView(view);
    // Up to 5 explosions will be playable simultaneously
    sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
    explosion = sp.load(this, R.raw.grenade, 1);
  }

  @Override
  public void onClick(View v) {
    // Prevent possibly playing before explosion has loaded
    if(explosion != 0) {
      sp.play(explosion, 1, 1, 0, 0, 1);
    }
  }
}
