package ch.expectusafterlun.androidtutorial;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements View.OnClickListener {

	ImageButton ib;
	Button b;
	ImageView iv;
	Intent i;
	final static int cameraData = 0;
	Bitmap bm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		initialize();
		/*
		 * Fixes bug from previous lesson, 41
		 * Set the Bitmap equal to the app icon
		 * In case the user hits the set wallpaper button
		 * Before taking a picture with the camera
		 */
		InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
		bm = BitmapFactory.decodeStream(is);
	}

	private void initialize() {
		iv = (ImageView) findViewById(R.id.iv_returned_pic);
		ib = (ImageButton) findViewById(R.id.ib_take_pic);
		b = (Button) findViewById(R.id.b_set_wallpaper);
		b.setOnClickListener(this);
		ib.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b_set_wallpaper:
			try {
				getApplicationContext().setWallpaper(bm);
			} catch (IOException e) {
				e.printStackTrace();
			}

			break;
		case R.id.ib_take_pic:
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, cameraData);

			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle extras = data.getExtras();
			bm = (Bitmap) extras.get("data");
			iv.setImageBitmap(bm);
		}
	}
}
