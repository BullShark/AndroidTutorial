package ch.expectusafterlun.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MemeCreator extends AppCompatActivity implements TopSectionFragment.TopSectionListener {

    private final static String TAG = "Meme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meme);
    }

    // This gets called by the Top Fragment when the user clicks the button.
    @Override
    public void createMeme(String top, String bottom) {
        BottomPictureFragment bottomFragment = (BottomPictureFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        Log.d(TAG, "method: createMeme(...), top: " + top + ", bottom: " + bottom);
        bottomFragment.setMemeText(top, bottom);
    }
}