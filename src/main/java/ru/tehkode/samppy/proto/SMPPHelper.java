package ru.tehkode.samppy.proto;

import java.nio.ByteBuffer;

public abstract class SMPPHelper {

    public static String readCString(ByteBuffer buffer, int maxLength) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < maxLength - 1; i++) {
            byte value = buffer.get();

            if (value == 0x00) {
                break;
            }

            builder.append(Character.toChars(value));
        }

        if (builder.length() == 0) {
            return null; // we ain't afraid of NPE, right?
        }

        return builder.toString();
    }

    public static void writeCString(ByteBuffer buffer, String string, int maxLength) {
        if (string != null) {
            String write = string;

            if (write.length() >= maxLength) {
                write = write.substring(0, maxLength);
                // @todo log warning
            }
            
            buffer.put(write.getBytes());
        }

        buffer.put((byte) 0x00);
    }
}
