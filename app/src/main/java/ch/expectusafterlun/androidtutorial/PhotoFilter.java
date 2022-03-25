package ch.expectusafterlun.androidtutorial;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.ImageView;

public class PhotoFilter extends Activity {

    private ImageView iv;
    private Drawable gentoo;
    private Bitmap bitmapImage;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_filter);

        iv = findViewById(R.id.imageView1);
        gentoo = getResources().getDrawable(R.drawable.gentoobig);
        bitmapImage = ((BitmapDrawable) gentoo).getBitmap();
        Bitmap newPhoto = invertImage(bitmapImage);
        iv.setImageBitmap(newPhoto);
    }

    private Bitmap invertImage(Bitmap bitmapImage) {
        return null;
    }
}