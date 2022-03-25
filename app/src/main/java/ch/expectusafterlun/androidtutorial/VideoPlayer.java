package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;
import android.widget.MediaController;

public class VideoPlayer extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_player);

        // Path to video
        VideoView vv = findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.taco_flavored_kisses;
        vv.setVideoURI(Uri.parse(path));

        // Player controls such as play, pause, stop, etc.
        MediaController mc = new MediaController(this);
        mc.setAnchorView(vv);
        vv.setMediaController(mc);

        vv.start();
    }
}