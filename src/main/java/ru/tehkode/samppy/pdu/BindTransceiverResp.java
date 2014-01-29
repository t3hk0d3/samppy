package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.SMPPCommand;

public class BindTransceiverResp extends BindResp<BindTransceiverResp> {

    public long commandId() {
        return SMPPCommand.BIND_TRANSCEIVER_RESP.commandId();
    }

    public Class<? extends MessagePDU> getMessageClass() {
        return BindTransceiver.class;
    }
}