package ru.tehkode.samppy.proto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractPDU<T extends AbstractPDU> implements PDU<T> {
        
    private long commandStatus = 0;
    private long sequenceNumber = 0;
    
    private final Set<OptionalParameter> parameters = new HashSet<OptionalParameter>();

    public long commandStatus() {
        return this.commandStatus;
    }

    public T commandStatus(long commandStatus) {
        this.commandStatus = commandStatus;
                
        return (T)this;
    }

    public long sequenceNumber() {
        return this.sequenceNumber;
    }

    public T sequenceNumber(long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
                
        return (T)this;
    }

    public Set<OptionalParameter> optionalParameters() {
        return this.parameters;
    }

    public T addOptionalParameter(OptionalParameter... parameters) {
        this.parameters.addAll(Arrays.asList(parameters));
        
        return (T)this;
    }

    public T removeOptionalParameter(OptionalParameter... parameters) {
        this.parameters.removeAll(Arrays.asList(parameters));
        
        return (T)this;
    }
    
    

}
