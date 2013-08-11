package ch.expectusafterlun.androidtutorial;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class AnimationViewSurface extends SurfaceView implements Runnable {

	SurfaceHolder holder;
	Thread thread;

	public AnimationViewSurface(Context context) {
		super(context);
		holder = getHolder();
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
	}

}
