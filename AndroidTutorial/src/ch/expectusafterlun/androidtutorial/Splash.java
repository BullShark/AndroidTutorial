package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

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
		
		ourSong = MediaPlayer.create(Splash.this, R.raw.dubstep);
		ourSong.start();
		
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
							"expectusafterlun.ch.androidtutorial.MENU");
					startActivity(openStartingPoint);
					
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