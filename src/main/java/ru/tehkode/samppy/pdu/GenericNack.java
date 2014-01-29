package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.SMPPCommand;

public class GenericNack extends AbstractPDU<GenericNack> {

    public long commandId() {
        return SMPPCommand.GENERIC_NACK.commandId();
    }

}
