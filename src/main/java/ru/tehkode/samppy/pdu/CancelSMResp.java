package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.SMPPCommand;

public class CancelSMResp extends AbstractPDU<CancelSMResp> implements ResponsePDU<CancelSMResp> {

    public long commandId() {
        return SMPPCommand.CANCEL_SM_RESP.commandId();
    }

    public Class<? extends MessagePDU> getMessageClass() {
        return CancelSM.class;
    }
}