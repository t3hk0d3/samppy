package ru.tehkode.samppy.proto;

public interface MessagePDU<T extends MessagePDU> extends PDU<T> {
    
    public Class<? extends ResponsePDU> getResponseClass();
}
