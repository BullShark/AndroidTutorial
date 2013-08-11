package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class GFXSurface extends Activity implements OnTouchListener {
	
	AnimationViewSurface surfaceView;
	float x, y;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		surfaceView = new AnimationViewSurface(this);
		surfaceView.setOnTouchListener(this);
		x = 0;
		y = 0;
		setContentView(surfaceView);
	}

	@Override
	protected void onPause() {
		super.onPause();
		surfaceView.pause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		surfaceView.resume();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		x = event.getX();
		y = event.getY();
		return false;
	}

}
