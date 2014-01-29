package ru.tehkode.samppy.proto;

public class DataCoding {
    public final static int VENDOR_SPECIFIC = 0;
    public final static int ANSI = 1;
    public final static int BINARY = 2;
    public final static int ISO_8859_1_LATIN = 3;
    public final static int JIS = 5;
    public final static int ISO_8859_5_CYRILIC = 6;
    public final static int ISO_8859_8_HEBREW = 7;
    public final static int UCS2 = 8; // UTF-16BE
    public final static int PICTOGRAM = 9;
    
    private byte value = 0;

    public DataCoding() {
    }
        
    public DataCoding(byte value) {
        this.value = value;
    }

    public byte value() {
        return value;
    }

    public DataCoding value(byte value) {
        this.value = value;
        
        return this;
    }
}
