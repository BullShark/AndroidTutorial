package ch.expectusafterlun.androidtutorial;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class AnimationViewSurface extends SurfaceView implements Runnable {

	private SurfaceHolder holder;
	private Thread thread;
	private boolean isRunning;

	public AnimationViewSurface(Context context) {
		super(context);
		holder = getHolder();
		isRunning = false;
	}

	public void pause() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread = null;
	}

	public void resume() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while (isRunning) {
			if (!holder.getSurface().isValid()) {
				continue;
			}

			Canvas canvas = holder.lockCanvas();
			canvas.drawRGB(2, 2, 150);
			holder.unlockCanvasAndPost(canvas);
		}
	}
}
