package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.SMPPCommand;

public class BindTransceiver extends Bind<BindTransceiver> {

    public long commandId() {
        return SMPPCommand.BIND_TRANSCEIVER.commandId();
    }

    public Class<? extends ResponsePDU> getResponseClass() {
        return BindTransceiverResp.class;
    }
}
