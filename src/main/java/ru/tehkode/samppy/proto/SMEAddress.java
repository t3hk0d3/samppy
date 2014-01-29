package ru.tehkode.samppy.proto;

import java.nio.ByteBuffer;

public class SMEAddress implements Destination {
    private TypeOfNumber addressTON = TypeOfNumber.UNKNOWN;
    private NumericPlanIndicator addressNPI = NumericPlanIndicator.UNKNOWN;
    private String address;

    public SMEAddress() {
    }
    
    public SMEAddress(String address, TypeOfNumber ton, NumericPlanIndicator npi) {
        this(address);
        this.addressNPI = npi;
        this.addressTON = ton;
    }

    public SMEAddress(ByteBuffer buffer) {
        this.addressTON = TypeOfNumber.lookup(buffer.get());
        this.addressNPI = NumericPlanIndicator.lookup(buffer.get());
        this.address = SMPPHelper.readCString(buffer);
    }

    public SMEAddress(String address) {
        this.address = address;
    }

    @Override
    public Type addressType() {
        return Type.SME_ADDRESS;
    }

    public TypeOfNumber addressTON() {
        return addressTON;
    }

    public SMEAddress addressTON(TypeOfNumber addressTON) {
        this.addressTON = addressTON;
        return this;
    }

    public NumericPlanIndicator addressNPI() {
        return addressNPI;
    }

    public SMEAddress addressNPI(NumericPlanIndicator addressNPI) {
        this.addressNPI = addressNPI;
        return this;
    }

    public String address() {
        return address;
    }

    public SMEAddress address(String address) {
        this.address = address;
        return this;
    }

    public void write(ByteBuffer buffer) {
        buffer.put(addressTON.value());
        buffer.put(addressNPI.value());
        SMPPHelper.writeCString(buffer, address);
    }
    
}
