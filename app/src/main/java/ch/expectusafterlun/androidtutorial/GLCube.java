package ch.expectusafterlun.androidtutorial;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class GLCube {

    /*
     * A Cube has 8 points.
     * x y and z coordinates for points 1-8
     */
    private final float VERTICES[] = {
            // Front points
            1, 1, -1,  //p0 - topFrontRight
            1, -1, -1  //p1 - bottomFrontRight
            -1, -1, -1,//p2 - bottomFrontLeft
            -1, 1, -1, //p3 - topFrontLeft

            // Back points
            1, 1, 1,  //p4 - topBackRight
            1, -1, 1  //p5 - bottomBackRight
            -1, -1, 1,//p6 - bottomBackLeft
            -1, 1, 1, //p7 - topBackLeft
    };

    private FloatBuffer vertBuff;

    /* Point Index and Point Buffer */
    private final short[] PINDEX = { 0, 1, 2 };

    private ShortBuffer pBuff;

    /* Each float takes up 4 bytes
     * We need to reserve 24 bytes
     */
    public GLCube() {
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
    }

    /* Connect the points clock-wise */
    public void draw(GL10 gl) {
        gl.glFrontFace(GL10.GL_CW);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
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
        gl.glDrawElements(GL10.GL_TRIANGLES, PINDEX.length, GL10.GL_UNSIGNED_SHORT, pBuff);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
