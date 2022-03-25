package ch.expectusafterlun.androidtutorial;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GLRenderer implements GLSurfaceView.Renderer {

    private final GLTriangle tri;

    public GLRenderer() {
        tri = new GLTriangle();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glDisable(GL10.GL_DITHER); /* Improve performance */
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
        gl.glClearColor(.8f, 0, .2f, 1);
        gl.glClearDepthf(1f);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glDisable(GL10.GL_DITHER);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();

        // Tell our camera to look at a specific point
        GLU.gluLookAt(gl, 0, 0, -5, 0, 0, 0, 0, 2, 0);

        tri.draw(gl);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        // The bottom left corner is (0, 0)
        gl.glViewport(0,0, width, height);
        // For keeping the same ratio if the phone changes landscape
        float ratio = (float) width / height;
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        // Our viewing area
        gl.glFrustumf(-ratio, ratio, -1, 1, 1, 25);
    }
}
