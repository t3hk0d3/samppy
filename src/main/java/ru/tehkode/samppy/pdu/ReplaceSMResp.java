package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.SMPPCommand;

public class ReplaceSMResp extends AbstractPDU<ReplaceSMResp> implements ResponsePDU<ReplaceSMResp> {

    public long commandId() {
        return SMPPCommand.REPLACE_SM_RESP.commandId();
    }

    public Class<? extends MessagePDU> getMessageClass() {
        return ReplaceSM.class;
    }
}