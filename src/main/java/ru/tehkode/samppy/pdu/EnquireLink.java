package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.SMPPCommand;

public class EnquireLink extends AbstractPDU<EnquireLink> implements MessagePDU<EnquireLink> {

    public long commandId() {
        return SMPPCommand.ENQUIRE_LINK.commandId();
    }

    public Class<? extends ResponsePDU> getResponseClass() {
        return EnquireLinkResp.class;
    }
}
