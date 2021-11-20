package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Accelerate extends AppCompatActivity implements SensorEventListener {

    private float x, y, sensorX, sensorY;
    private Bitmap ball;
    private SensorManager sm;
    AnimationViewSurface animationViewSurface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Check if the device has an accelerometer
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(sm.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0) {
            Sensor sensor = sm.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
            sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

        ball = BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
        x = y = sensorX = sensorY = 0;

        animationViewSurface = new AnimationViewSurface(this);
        // Won't run because everything is set to false until the resume() method
        animationViewSurface.resume();
        setContentView(animationViewSurface);
    }

    // Since we registered are listener, we want to create an onPause() method and unregister it
    // So it's not always playing
    @Override
    protected void onPause() {
        sm.unregisterListener(this);
        super.onPause();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // Have the ball move around the screen when the sensor changes
        // This gets called when we have a new SensorEvent,
        // When our accelerometer changes directions

        // Add a delay
        try {
            Thread.sleep(16); // 16 is about 60 fps
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sensorX = event.values[0];
        sensorY = event.values[1];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Test the accuracy of the changed event

    }

    public class AnimationViewSurface extends SurfaceView implements Runnable {

        private final SurfaceHolder holder;
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
                // Paint our Bitmap in the center
                // It's not the center of the Bitmap itself so a little bit off
                float centerX = canvas.getWidth() / 2;
                float centerY = canvas.getHeight() / 2;
                // The sensor varies from 0 to 40 is the amount of force that can be applied
                // So amplify the amount of pixels it's going to be able to move by 30
                canvas.drawBitmap(ball, centerX + sensorX*30, centerY + sensorY*30, null);

                holder.unlockCanvasAndPost(canvas);
            }
        }
    }
}