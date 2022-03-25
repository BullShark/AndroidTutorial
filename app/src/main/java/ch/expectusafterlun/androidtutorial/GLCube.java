package ch.expectusafterlun.androidtutorial;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class GLCube {

    private final FloatBuffer vertBuff;

    /*
     * Point Index of sections
     * Creating the cube as triangle sections
     * Going in the clockwise direction
     * See GLCube Reference Diagram.png
     */
    private final short[] PINDEX = {
            3, 4, 0,   0, 4, 1,   3, 0, 1, // Top right section
            3, 7, 4,   7, 6, 4,   7, 3, 6, // Top left section
            3, 1, 2,   1, 6, 2,   6, 3, 2, // Bottom left section
            1, 4, 5,   5, 6, 1,   6, 5, 4  // Bottom right section
    };

    /*
     * Point Buffer
     */
    private final ShortBuffer pBuff;

    /* Each float takes up 4 bytes
     * We need to reserve 24 bytes
     */
    public GLCube() {
        // Floats
        /*
         * Points, not sections
         * A Cube has 8 points.
         * x y and z coordinates for points 1-8
         */
        // Front points
        //p0 - topFrontRight
        //p1 - bottomFrontRight
        //p2 - bottomFrontLeft
        //p3 - topFrontLeft
        // Back points
        //p4 - topBackRight
        //p5 - bottomBackRight
        //p6 - bottomBackLeft
        //p7 - topBackLeft
        float[] VERTICES = {
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
        /* Draw the front faces of the triangle
         * Don't worry about the back face which would
         * Only be visible from the inside of the cube
         */
        gl.glEnable(GL10.GL_CULL_FACE);
        /* Refers to the face that
         * We want to ignore drawing
         */
        gl.glCullFace(GL10.GL_BACK);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        /* 3 dimensional object, type is a float,
         * stride is for skipping elements in an array, not needed here
         */
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertBuff);
        /* Going clock-wise
         * Mode: How we want to draw, triangle sections
         * How many points or indexes do we have
         * The data type we are working with
         * Our buffer
         */
        gl.glDrawElements(GL10.GL_TRIANGLES, PINDEX.length, GL10.GL_UNSIGNED_SHORT, pBuff);
        /* We enabled these 2 above
         * Now we have to disable them
         */
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisable(GL10.GL_CULL_FACE);
    }
}
