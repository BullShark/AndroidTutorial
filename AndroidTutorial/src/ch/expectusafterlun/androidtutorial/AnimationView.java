package ch.expectusafterlun.androidtutorial;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

public class AnimationView extends View {

	Bitmap gBall;
	
	public AnimationView(Context context) {
		super(context);
		gBall = BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
	}
}