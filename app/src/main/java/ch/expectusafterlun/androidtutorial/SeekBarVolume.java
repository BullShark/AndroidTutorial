package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.SeekBar;

public class SeekBarVolume extends Activity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar sb;
    private MediaPlayer mp;
    private AudioManager am;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbarvolume);
        sb = (SeekBar) findViewById(R.id.sb_volume);
        mp = MediaPlayer.create(this, R.raw.dubstep);
        mp.start();
        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxV = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curV = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        sb.setMax(maxV);
        sb.setProgress(curV);
        sb.setOnSeekBarChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.release();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        am.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
