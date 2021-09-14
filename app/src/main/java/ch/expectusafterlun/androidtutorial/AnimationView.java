package ch.expectusafterlun.androidtutorial;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

public class AnimationView extends View {

	private final Bitmap gBall;
	private float changingY;
	private final Typeface font;
	
	public AnimationView(Context context) {
		super(context);
		gBall = BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
		changingY = 0;
		font = Typeface.createFromAsset(context.getAssets(), "segoesc.ttf");
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		
		Paint textPaint = new Paint();
		textPaint.setARGB(50, 254, 10, 50);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTextSize(50);
		textPaint.setTypeface(font);
		canvas.drawText("Custom font text", canvas.getWidth()/2, canvas.getHeight()/2, textPaint);
		
		// 100 pixels is the width of the green ball, 50 is half
		canvas.drawBitmap(gBall, (canvas.getWidth()/2 - gBall.getScaledWidth(canvas)/2), changingY, null);
		if(changingY < canvas.getHeight()) {
			changingY += 10;
		} else {
			changingY = 10;
		}
		Rect midRect = new Rect();
		midRect.set(0, canvas.getHeight()/5, canvas.getWidth(), canvas.getHeight()/4);
		Paint customBlue = new Paint();
		customBlue.setColor(Color.BLUE);
		// ball goes behind the rectangle because it was drawn first on the canvas
		canvas.drawRect(midRect, customBlue);
		
		invalidate();
	}

}