package ru.tehkode.samppy.proto;

public interface PDU<T extends PDU> {
    
    public long commandId();    
    
    public long commandStatus();    
    public T commandStatus(long commandStatus);
    
    public long sequenceNumber();    
    public T sequenceNumber(long sequenceNumber);
    
}
