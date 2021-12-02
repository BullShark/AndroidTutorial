package ch.expectusafterlun.androidtutorial;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class GLTriangle {
    /* x and y coordinates for point 1, 2 and 3 */
    private final float VERTICES[] = {
            0f, 1f,
            1f, -1f,
            -1f, -1f
    };

    private FloatBuffer vertBuff;

    /* Point Index and Point Buffer */
    private short[] pIndex = { 0, 1, 2 };

    private ShortBuffer pBuff;

    /* Each float takes up 4 bytes
     * We need to reserve 24 bytes
     */
    public GLTriangle() {
        ByteBuffer bBuff = ByteBuffer.allocateDirect(VERTICES.length * 4);
        bBuff.order(ByteOrder.nativeOrder());
        vertBuff = bBuff.asFloatBuffer();
        vertBuff.put(VERTICES);
        vertBuff.position(0);

        ByteBuffer pbBuff = ByteBuffer.allocateDirect(pIndex.length * 2);
        pbBuff.order(ByteOrder.nativeOrder());
        pBuff = pbBuff.asShortBuffer();
        pBuff.put(pIndex);
        pBuff.position(0);
    }
}
