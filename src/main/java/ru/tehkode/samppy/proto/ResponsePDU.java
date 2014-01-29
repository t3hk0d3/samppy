package ru.tehkode.samppy.proto;

public interface ResponsePDU<T extends ResponsePDU> extends PDU<T> {
    
    public Class<? extends MessagePDU> getMessageClass();
    
}
