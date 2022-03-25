package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class TakePhoto extends Activity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView buckysImageView;
    private Button buckysButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.take_photo);

        buckysButton = findViewById(R.id.buckysButton);
        buckysImageView = findViewById(R.id.buckysImageView);

        // Disable the button if the user has no camera
        if(!hasCamera()) {
            buckysButton.setEnabled(false);
        }
    }

    private boolean hasCamera() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    public void launchCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Take a picture and pass the results along to onActivityResult
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // Get the photo
            Bundle extras = null;
            if (data != null) {
                extras = data.getExtras();
                Bitmap photo = (Bitmap) extras.get("data");
                buckysImageView.setImageBitmap(photo);
            }
        }
    }
}