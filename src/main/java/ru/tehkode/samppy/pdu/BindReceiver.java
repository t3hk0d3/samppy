package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.SMPPCommand;

public class BindReceiver extends Bind<BindReceiver> {

    public long commandId() {
        return SMPPCommand.BIND_RECEIVER.commandId();
    }

    public Class<? extends ResponsePDU> getResponseClass() {
        return BindReceiverResp.class;
    }
}
