package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.NumericPlanIndicator;
import ru.tehkode.samppy.proto.SMPPCOctet;
import ru.tehkode.samppy.proto.SMPPInteger;
import ru.tehkode.samppy.proto.TypeOfNumber;

public abstract class Bind<T extends Bind> extends AbstractPDU<T> implements MessagePDU<T> {
    
    @SMPPCOctet(order=0, maxLength=16)
    private String systemId;
    
    @SMPPCOctet(order=1, maxLength=9)
    private String password;
    
    @SMPPCOctet(order=2, maxLength=13)
    private String systemType;
    
    @SMPPInteger(order=3)
    private byte interfaceVersion;
    
    @SMPPInteger(order=4)
    private TypeOfNumber addr_ton;
    
    @SMPPInteger(order=5)
    private NumericPlanIndicator addr_npi;
    
    @SMPPInteger(order=6)
    private String addressRange;

    public String systemId() {
        return systemId;
    }

    public T systemId(String systemId) {
        this.systemId = systemId;
        
        return (T)this;
    }

    public String password() {
        return password;
    }

    public T password(String password) {
        this.password = password;
        
        return (T)this;
    }

    public String systemType() {
        return systemType;
    }

    public T systemType(String systemType) {
        this.systemType = systemType;
        
        return (T)this;
    }

    public byte interfaceVersion() {
        return interfaceVersion;
    }

    public T interfaceVersion(byte interfaceVersion) {
        this.interfaceVersion = interfaceVersion;
        
        return (T)this;
    }

    public TypeOfNumber addrTON() {
        return addr_ton;
    }

    public T addrTON(TypeOfNumber addr_ton) {
        this.addr_ton = addr_ton;
        
        return (T)this;
    }

    public NumericPlanIndicator addrNPI() {
        return addr_npi;
    }

    public T addrNPI(NumericPlanIndicator addr_npi) {
        this.addr_npi = addr_npi;
        
        return (T)this;
    }

    public String addressRange() {
        return addressRange;
    }

    public T addressRange(String addressRange) {
        this.addressRange = addressRange;
        
        return (T)this;
    }
    
    
}
