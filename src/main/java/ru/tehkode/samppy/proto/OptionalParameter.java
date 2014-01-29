package ru.tehkode.samppy.proto;

public interface OptionalParameter<T extends OptionalParameter> {
    
    short tag();
    T tag(short tag);    
    
    short length();
    
    byte[] value();
    T value(byte[] value);
    
}
