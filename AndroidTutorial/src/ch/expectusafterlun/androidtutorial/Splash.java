package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity {

	public MediaPlayer ourSong;
	private static boolean calledOnce = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

		if(!calledOnce) {
			calledOnce = true;
		} else {
			return;
		}
		
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		
		// The second parameter is a default value that will be used if no value exists
		boolean music = getPrefs.getBoolean("checkbox", true);
		ourSong = MediaPlayer.create(Splash.this, R.raw.dubstep);
		
		if(music) {
			ourSong.start();
		}
		
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(8000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					/*
					 * Kill the sound clip before starting the next Activity
					 * Or if the Activity has gone to onPause state
					 * After the sleep duration of this thread
					 */
					ourSong.release(); 
					Intent openStartingPoint = new Intent(
							"ch.expectusafterlun.androidtutorial.MENU");
					startActivity(openStartingPoint);
					finish();
					
					/*
					 * Reset calledOnce to false
					 * For the next time this Application is run
					 */
					calledOnce = false;
				}
			}
		};
		timer.start();	
	}
}