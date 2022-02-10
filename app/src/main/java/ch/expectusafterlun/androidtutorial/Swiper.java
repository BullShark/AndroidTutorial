package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;

import android.os.Bundle;

public class Swiper extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private TextView tv;
    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swiper);

        tv = (TextView) findViewById(R.id.tv_bucky);
        gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        tv.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        tv.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        tv.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        tv.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        tv.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        tv.setText("onFling");
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        tv.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        tv.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        tv.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}