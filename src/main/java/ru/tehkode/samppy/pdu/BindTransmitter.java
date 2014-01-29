package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.SMPPCommand;

public class BindTransmitter extends Bind<BindTransmitter> {

    public long commandId() {
        return SMPPCommand.BIND_TRANSMITTER.commandId();
    }

    public Class<? extends ResponsePDU> getResponseClass() {
        return BindTransmitterResp.class;
    }
}
