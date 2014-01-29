package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.SMPPCOctet;
import ru.tehkode.samppy.proto.SMPPCommand;

public class SubmitSMResp extends AbstractPDU<SubmitSMResp> implements ResponsePDU<SubmitSMResp> {

    @SMPPCOctet(order = 1, maxLength=65)
    private String messageId;

    public String messageId() {
        return messageId;
    }

    public SubmitSMResp messageId(String messageId) {
        this.messageId = messageId;
        
        return this;
    }
    
    public long commandId() {
        return SMPPCommand.SUBMIT_SM_RESP.commandId();
    }

    public Class<? extends MessagePDU> getMessageClass() {
        return SubmitSM.class;
    }
}