package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.SMPPCOctet;

public abstract class BindResp<T extends BindResp> extends AbstractPDU<T> implements ResponsePDU<T> {

    @SMPPCOctet(order = 0, maxLength = 16)
    private String systemId;

    public String systemId() {
        return systemId;
    }

    public T systemId(String systemId) {
        this.systemId = systemId;

        return (T) this;
    }
}
