package ru.tehkode.samppy.proto;

import java.util.HashMap;
import java.util.Map;

public enum TypeOfNumber {
    UNKNOWN(0),
    INTERNATIONAL(1),
    NATIONAL(2),
    NETWORK_SPECIFIC(3),
    SUBSCRIBER_NUMBER(4),
    ALPHANUMERIC(5),
    ABBREVIATED(6);
    
    private final static Map<Byte, TypeOfNumber> lookup = new HashMap<Byte, TypeOfNumber>(TypeOfNumber.values().length);

    private final byte value;
    
    static {
        for(TypeOfNumber ton : TypeOfNumber.values()) {
            lookup.put(ton.value(), ton);
        }
    }
    
    private TypeOfNumber(int value) {
        this.value = (byte) value;
    }
    
    public byte value() {
        return this.value;
    }
    
    public static TypeOfNumber lookup(byte value) {
        TypeOfNumber ton = lookup.get(value);
        
        if(ton == null) {
            throw new IllegalArgumentException("Unknown type of number (" + value + ")");
        }
        
        return ton;
    }
}
