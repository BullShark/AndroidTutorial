package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * @author Christopher Lemire
 */
public class SoundStuff extends Activity implements View.OnClickListener, View.OnLongClickListener {
  // SoundPool is for shorter sounds/audio clips as
  // Opposed to MediaPlayer for longer sounds
  private SoundPool sp;
  private MediaPlayer mp;
  private int explosion = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    View view = new View(this);
    view.setOnClickListener(this);
    view.setOnLongClickListener(this);
    setContentView(view);
    // Up to 5 explosions will be playable simultaneously
    sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
    explosion = sp.load(this, R.raw.grenade, 1);
    mp = MediaPlayer.create(this, R.raw.dubstep);
  }

  @Override
  public void onClick(View v) {
    // Prevent possibly playing before explosion has loaded
    if(explosion != 0) {
     sp.play(explosion, 1, 1, 0, 0, 1);
    }
  }

  @Override
  public boolean onLongClick(View v) {
    Log.i("SoundStuff", "Long-click sound starting...");
    mp.start();
    return true;
  }
}

