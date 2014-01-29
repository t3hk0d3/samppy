package ru.tehkode.samppy.pdu;



import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.SMPPCommand;

public class UnbindResp extends AbstractPDU<UnbindResp> implements ResponsePDU<UnbindResp> {

    public long commandId() {
        return SMPPCommand.UNBIND_RESP.commandId();
    }

    public Class<? extends MessagePDU> getMessageClass() {
        return Unbind.class;
    }
}