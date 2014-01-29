/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tehkode.samppy.proto;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author t3hk0d3
 */
public enum NumericPlanIndicator {
    UNKNOWN(0),
    ISDN(1),
    DATA(2),
    TELEX(3),
    LAND_MOBILE(4),
    NATIONAL(5),
    PRIVATE(6),
    ERMES(7),
    INTERNET(8),
    WAP(9);
    
    private final static Map<Byte, NumericPlanIndicator> lookup = new HashMap<Byte, NumericPlanIndicator>(NumericPlanIndicator.values().length);
    private final byte value;

    static {
        for (NumericPlanIndicator ton : NumericPlanIndicator.values()) {
            lookup.put(ton.value(), ton);
        }
    }

    private NumericPlanIndicator(int value) {
        this.value = (byte) value;
    }

    public byte value() {
        return this.value;
    }
    
    public static NumericPlanIndicator lookup(byte value) {
        NumericPlanIndicator npi = lookup.get(value);
        
        if(npi == null) {
            throw new IllegalArgumentException("Unknown numeric plan indicator (" + value + ")");
        }
        
        return npi;
    }
}
