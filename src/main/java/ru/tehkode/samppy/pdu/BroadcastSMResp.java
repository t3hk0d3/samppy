package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.SMPPCOctet;
import ru.tehkode.samppy.proto.SMPPCommand;

public class BroadcastSMResp extends AbstractPDU<BroadcastSMResp> implements ResponsePDU<BroadcastSMResp> {

    @SMPPCOctet(order = 1, maxLength = 65)
    private String messageId;

    public String messageId() {
        return messageId;
    }

    public BroadcastSMResp messageId(String messageId) {
        this.messageId = messageId;

        return this;
    }

    public long commandId() {
        return SMPPCommand.BROADCAST_SM_RESP.commandId();
    }

    public Class<? extends MessagePDU> getMessageClass() {
        return BroadcastSM.class;
    }
}