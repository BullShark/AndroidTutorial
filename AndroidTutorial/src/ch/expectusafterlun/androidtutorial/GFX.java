package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;

public class GFX extends Activity {

	private AnimationView view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view = new AnimationView(this);
		setContentView(view);
	}

}
