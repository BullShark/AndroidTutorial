package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
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
		return true;
	}

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
				if(x != 0 && y != 0) {
					Bitmap test = BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
					canvas.drawBitmap(test, x - (test.getWidth()/2), y - (test.getHeight()/2), null);
				}
				holder.unlockCanvasAndPost(canvas);
			}
		}
	}
}
