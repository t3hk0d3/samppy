package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.SMPPCommand;

public class BindReceiverResp extends BindResp<BindReceiverResp> {

    public long commandId() {
        return SMPPCommand.BIND_RECEIVER_RESP.commandId();
    }

    public Class<? extends MessagePDU> getMessageClass() {
        return BindReceiver.class;
    }
}
