package ru.tehkode.samppy.proto;

import java.nio.ByteBuffer;
import org.junit.Test;
import static org.junit.Assert.*;

public class SMPPHelperTest {

    // "hello world\0"
    private final static byte[] testBytes = new byte[]{104, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 0};

    @Test
    public void testWriteCString() {
        ByteBuffer testBuffer = ByteBuffer.allocate(testBytes.length);

        SMPPHelper.writeCString(testBuffer, "hello world", 15);

        assertArrayEquals(testBytes, testBuffer.array());
    }

    @Test
    public void testReadCString() {
        ByteBuffer testBuffer = ByteBuffer.wrap(testBytes);

        String result = SMPPHelper.readCString(testBuffer, 15);

        assertEquals("hello world", result);
    }
}
