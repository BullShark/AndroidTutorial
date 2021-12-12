package ch.expectusafterlun.androidtutorial;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class GLTriangle {
    /* x and y coordinates for point 1, 2 and 3 */
    private final float VERTICES[] = {
            0f, 1f,
            1f, -1f,
            -1f, -1f
    };

    private final float RGBAVals[] = {
            1,    1,  0, .5f,
            .25f, 0, .85f, 1,
            0,    1,  1,  1
    };

    private FloatBuffer vertBuff, colorBuff;

    /* Point Index and Point Buffer */
    private final short[] PINDEX = { 0, 1, 2 };

    private ShortBuffer pBuff;

    /* Each float takes up 4 bytes
     * We need to reserve 24 bytes
     */
    public GLTriangle() {
        // Floats
        ByteBuffer bBuff = ByteBuffer.allocateDirect(VERTICES.length * 4);
        bBuff.order(ByteOrder.nativeOrder());
        vertBuff = bBuff.asFloatBuffer();
        vertBuff.put(VERTICES);
        vertBuff.position(0);

        // Shorts
        ByteBuffer pbBuff = ByteBuffer.allocateDirect(PINDEX.length * 2);
        pbBuff.order(ByteOrder.nativeOrder());
        pBuff = pbBuff.asShortBuffer();
        pBuff.put(PINDEX);
        pBuff.position(0);

        // Shorts - Color
        ByteBuffer cBuff = ByteBuffer.allocateDirect(RGBAVals.length * 4);
        cBuff.order(ByteOrder.nativeOrder());
        colorBuff = cBuff.asFloatBuffer();
        colorBuff.put(RGBAVals);
        colorBuff.position(0);
    }

    /* Connect the points clock-wise */
    public void draw(GL10 gl) {
        gl.glFrontFace(GL10.GL_CW);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        /* 2 dimensional object, type is a float,
         * stride is for skipping elements in an array, not needed here
         */
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertBuff);
        /* Going clock-wise
         * Mode: How we want to draw
         * How many points or indexes do we have
         * The data type we are working with
         * Our buffer
         */
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuff);
        gl.glDrawElements(GL10.GL_TRIANGLES, PINDEX.length, GL10.GL_UNSIGNED_SHORT, pBuff);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
