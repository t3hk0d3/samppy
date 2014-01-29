package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.SMPPCOctet;
import ru.tehkode.samppy.proto.SMPPCommand;

public class Outbind extends AbstractPDU<Outbind> {

    @SMPPCOctet(order = 0, maxLength = 16)
    private String systemId;
    
    @SMPPCOctet(order = 1, maxLength = 9)
    private String password;

    public long commandId() {
        return SMPPCommand.OUTBIND.commandId();
    }

    public String systemId() {
        return systemId;
    }

    public Outbind systemId(String systemId) {
        this.systemId = systemId;

        return this;
    }

    public String password() {
        return password;
    }

    public Outbind password(String password) {
        this.password = password;

        return this;
    }
}
