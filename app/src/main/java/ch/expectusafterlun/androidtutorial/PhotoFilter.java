package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.widget.ImageView;

public class PhotoFilter extends Activity {

    private ImageView iv;
    private Drawable gentoo;
    private Bitmap bitmapImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_filter);

        iv = findViewById(R.id.imageView1);

        gentoo = getApplicationContext().getDrawable(R.drawable.gentoo);
        bitmapImage = ((BitmapDrawable) gentoo).getBitmap();
        Bitmap newPhoto = invertImage(bitmapImage);
        iv.setImageBitmap(newPhoto);

        // Save an image on the device to the gallery
        MediaStore.Images.Media.insertImage(getContentResolver(), newPhoto, "Missing my dog", "Looking good");
    }

    public static Bitmap invertImage(Bitmap original) {
        Bitmap finalImage = Bitmap.createBitmap(original.getWidth(), original.getHeight(), original.getConfig());

        int A, R, G, B;
        int pixelColor;
        int height = original.getHeight();
        int width = original.getWidth();

        // Loop through image pixels rows and columns
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                pixelColor = original.getPixel(x, y);
                A = Color.alpha(pixelColor);
                R = 255 - Color.red(pixelColor);
                G = 255 - Color.green(pixelColor);
                B = 255 - Color.blue(pixelColor);
                finalImage.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }

        return finalImage;
    }
}