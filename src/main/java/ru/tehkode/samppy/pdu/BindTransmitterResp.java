package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.SMPPCommand;

public class BindTransmitterResp extends BindResp<BindTransmitterResp> {

    public long commandId() {
        return SMPPCommand.BIND_TRANSMITTER_RESP.commandId();
    }

    public Class<? extends MessagePDU> getMessageClass() {
        return BindTransmitter.class;
    }
}