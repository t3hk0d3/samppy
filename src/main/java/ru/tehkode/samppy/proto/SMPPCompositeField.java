package ru.tehkode.samppy.proto;

import java.nio.ByteBuffer;

public interface SMPPCompositeField<T> {
    
    public T deserialize(ByteBuffer buffer);    
    public void serialize(ByteBuffer buffer, T object);
    
}
