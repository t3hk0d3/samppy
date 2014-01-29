package ru.tehkode.samppy.proto;

import java.nio.ByteBuffer;

public class DistributionList implements Destination {
    private String listName;

    public DistributionList() {
    }

    public DistributionList(ByteBuffer buffer) {
        this(SMPPHelper.readCString(buffer, 21));
    }

    public DistributionList(String listName) {
        this.listName = listName;
    }

    public String listName() {
        return listName;
    }

    public DistributionList listName(String listName) {
        this.listName = listName;
        return this;
    }

    @Override
    public Type addressType() {
        return Type.DISTRIBUTION_LIST;
    }

    public void write(ByteBuffer buffer) {
        SMPPHelper.writeCString(buffer, this.listName, 21);
    }
    
}
