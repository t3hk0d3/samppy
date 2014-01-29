package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.MessageState;
import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.SMPPCOctet;
import ru.tehkode.samppy.proto.SMPPCommand;
import ru.tehkode.samppy.proto.SMPPDate;
import ru.tehkode.samppy.proto.SMPPInteger;

public class QuerySMResp extends AbstractPDU<QuerySMResp> implements ResponsePDU<QuerySMResp> {

    @SMPPCOctet(order = 1, maxLength = 65)
    private String messageId;
    @SMPPCOctet(order = 2, maxLength = 17)
    private SMPPDate finalDate;
    @SMPPInteger(order = 3)
    private MessageState messageState;
    @SMPPInteger(order = 4)
    private int errorCode;

    public String messageId() {
        return messageId;
    }

    public QuerySMResp messageId(String messageId) {
        this.messageId = messageId;
        
        return this;
    }

    public SMPPDate finalDate() {
        return finalDate;
    }

    public QuerySMResp finalDate(SMPPDate finalDate) {
        this.finalDate = finalDate;
        
        return this;
    }

    public MessageState messageState() {
        return messageState;
    }

    public QuerySMResp messageState(MessageState messageState) {
        this.messageState = messageState;
        
        return this;
    }

    public int errorCode() {
        return errorCode;
    }

    public QuerySMResp errorCode(int errorCode) {
        this.errorCode = errorCode;
        
        return this;
    }
    
    public long commandId() {
        return SMPPCommand.QUERY_SM_RESP.commandId();
    }

    public Class<? extends MessagePDU> getMessageClass() {
        return QuerySM.class;
    }
}