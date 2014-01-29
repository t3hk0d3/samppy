package ru.tehkode.samppy.pdu;



import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.SMPPCommand;

public class Unbind extends AbstractPDU<Unbind> implements MessagePDU<Unbind> {

    public long commandId() {
        return SMPPCommand.UNBIND.commandId();
    }

    public Class<? extends ResponsePDU> getResponseClass() {
        return UnbindResp.class;
    }
}
