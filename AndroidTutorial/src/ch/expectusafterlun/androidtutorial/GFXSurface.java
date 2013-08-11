package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;

public class GFXSurface extends Activity {
	
	AnimationViewSurface surfaceView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		surfaceView = new AnimationViewSurface(this);
		setContentView(surfaceView);
	}

}
