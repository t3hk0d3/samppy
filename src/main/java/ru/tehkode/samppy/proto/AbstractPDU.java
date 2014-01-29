package ru.tehkode.samppy.proto;

public abstract class AbstractPDU<T extends AbstractPDU> implements PDU<T> {
        
    private long commandStatus = 0;
    private long sequenceNumber = 0;

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

}
