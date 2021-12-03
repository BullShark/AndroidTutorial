package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class GLCubeEx extends Activity {

    private GLSurfaceView surface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        surface = new GLSurfaceView(this);
        surface.setRenderer((GLSurfaceView.Renderer)new GLCubeRendererEx());
        setContentView(surface);
    }

    @Override
    protected void onPause() {
        super.onPause();
        surface.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        surface.onResume();
    }
}
