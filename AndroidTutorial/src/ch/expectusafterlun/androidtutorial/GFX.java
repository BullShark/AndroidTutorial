package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;

public class GFX extends Activity {

	private AnimationView view;
    private PowerManager.WakeLock wl;

  @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

    // Prevent the display from timing out/turning off
    // Why does video 78 show super.onCreate(Bundle) being called directly after PowerManager?
    PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
    wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "FULL_WAKE_LOCK Demo: Preventing the display from turning off " +
        "while this Activity is active");
    wl.acquire();

		view = new AnimationView(this);
		setContentView(view);
	}

  @Override
  protected void onResume() {
    super.onResume();
    wl.acquire();
  }

  @Override
  protected void onPause() {
    super.onPause();
    wl.release();
  }

}
