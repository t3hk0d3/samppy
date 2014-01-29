package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.pdu.SubmitSM;
import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.NumericPlanIndicator;
import ru.tehkode.samppy.proto.SMPPCOctet;
import ru.tehkode.samppy.proto.SMPPCommand;
import ru.tehkode.samppy.proto.SMPPInteger;
import ru.tehkode.samppy.proto.TypeOfNumber;

public class QuerySM extends AbstractPDU<QuerySM> implements MessagePDU<QuerySM> {

    @SMPPCOctet(order = 1, maxLength = 65)
    private String messageId;
    @SMPPInteger(order = 2)
    private TypeOfNumber sourceAddrTON;
    @SMPPInteger(order = 3)
    private NumericPlanIndicator sourceAddrNPI;
    @SMPPCOctet(order = 4, maxLength = 21)
    private String sourceAddr;

    public TypeOfNumber sourceAddrTON() {
        return sourceAddrTON;
    }

    public QuerySM sourceAddrTON(TypeOfNumber sourceAddrTON) {
        this.sourceAddrTON = sourceAddrTON;

        return this;
    }

    public NumericPlanIndicator sourceAddrNPI() {
        return sourceAddrNPI;
    }

    public QuerySM sourceAddrNPI(NumericPlanIndicator sourceAddrNPI) {
        this.sourceAddrNPI = sourceAddrNPI;

        return this;
    }

    public String sourceAddr() {
        return sourceAddr;
    }

    public QuerySM sourceAddr(String sourceAddr) {
        this.sourceAddr = sourceAddr;

        return this;
    }

    public long commandId() {
        return SMPPCommand.QUERY_SM.commandId();
    }

    public Class<? extends ResponsePDU> getResponseClass() {
        return QuerySMResp.class;
    }
}
