package ru.tehkode.samppy.proto;

import java.util.Set;

public interface PDU<T extends PDU> {
    
    long commandId();    
    
    long commandStatus();    
    T commandStatus(long commandStatus);
    
    long sequenceNumber();    
    T sequenceNumber(long sequenceNumber);
    
    Set<OptionalParameter> optionalParameters();
    T addOptionalParameter(OptionalParameter... parameters);
    T removeOptionalParameter(OptionalParameter... parameters);  
    
}
