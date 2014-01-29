package ru.tehkode.samppy.proto;

import java.nio.ByteBuffer;

public abstract class SMPPHelper {

    public static String readCString(ByteBuffer buffer) {
        byte value;

        StringBuilder builder = new StringBuilder();

        while ((value = buffer.get()) != 0x00) {
            builder.append(Character.toChars(value));
        }
        
        if(builder.length() == 0) {
            return null; // we ain't afraid of NPE, right?
        }

        return builder.toString();
    }

    public static void writeCString(ByteBuffer buffer, String string) {
        if (string != null) {
            buffer.put(string.getBytes());
        }
        
        buffer.put((byte) 0x00);
    }
}
