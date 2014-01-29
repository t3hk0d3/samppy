package ru.tehkode.samppy.proto;

import java.nio.ByteBuffer;

public interface SMPPFieldHandler<T> {
    
    public Class<T> fieldClass();
    
    public T deserialize(ByteBuffer buffer);    
    public void serialize(ByteBuffer buffer, T object);
    
}
