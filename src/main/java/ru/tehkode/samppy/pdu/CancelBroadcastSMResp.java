package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.SMPPCommand;

public class CancelBroadcastSMResp extends AbstractPDU<CancelBroadcastSMResp> implements ResponsePDU<CancelBroadcastSMResp> {

    public long commandId() {
        return SMPPCommand.CANCEL_BROADCAST_SM_RESP.commandId();
    }

    public Class<? extends MessagePDU> getMessageClass() {
        return CancelBroadcastSM.class;
    }
}