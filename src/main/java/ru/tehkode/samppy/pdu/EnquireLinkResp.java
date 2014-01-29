package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.SMPPCommand;

public class EnquireLinkResp extends AbstractPDU<EnquireLinkResp> implements ResponsePDU<EnquireLinkResp> {

    public long commandId() {
        return SMPPCommand.ENQUIRE_LINK_RESP.commandId();
    }

    public Class<? extends MessagePDU> getMessageClass() {
        return EnquireLink.class;
    }
}