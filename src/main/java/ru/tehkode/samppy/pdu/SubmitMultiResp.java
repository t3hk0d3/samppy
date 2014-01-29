package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.Destination;
import ru.tehkode.samppy.proto.ErrorSMEAddress;
import ru.tehkode.samppy.proto.SMPPCOctet;
import ru.tehkode.samppy.proto.SMPPCommand;
import ru.tehkode.samppy.proto.SMPPComposite;

public class SubmitMultiResp extends AbstractPDU<SubmitMultiResp> implements ResponsePDU<SubmitMultiResp> {

    @SMPPCOctet(order = 1, maxLength = 65)
    private String messageId;
    
    @SMPPComposite(order = 2, adapter = ErrorSMEAddress.Adapter.class)
    private Destination.List<ErrorSMEAddress> errorList = new Destination.List<ErrorSMEAddress>();

    public String messageId() {
        return messageId;
    }

    public SubmitMultiResp messageId(String messageId) {
        this.messageId = messageId;

        return this;
    }

    public long commandId() {
        return SMPPCommand.SUBMIT_MULTI.commandId();
    }

    public Class<? extends MessagePDU> getMessageClass() {
        return SubmitMulti.class;
    }
}