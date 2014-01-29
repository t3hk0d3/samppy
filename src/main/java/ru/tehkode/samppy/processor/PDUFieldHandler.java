package ru.tehkode.samppy.processor;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

public interface PDUFieldHandler {

    Field field();

    void read(Object obj, ByteBuffer buffer) throws IllegalAccessException;

    void write(ByteBuffer buffer, Object obj) throws IllegalAccessException;

    int order();
    
}
