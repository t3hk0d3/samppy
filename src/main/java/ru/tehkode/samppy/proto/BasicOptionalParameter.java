package ru.tehkode.samppy.proto;

public class BasicOptionalParameter implements OptionalParameter<BasicOptionalParameter> {
    private short tag;
    private byte[] value;

    public short tag() {
        return this.tag;
    }

    public BasicOptionalParameter tag(short tag) {
        this.tag = tag;
        return this;
    }

    public short length() {
        return (short)this.value.length;
    }

    public byte[] value() {
        return this.value;
    }

    public BasicOptionalParameter value(byte[] value) {
        this.value = value;
        
        return this;
    }
}
