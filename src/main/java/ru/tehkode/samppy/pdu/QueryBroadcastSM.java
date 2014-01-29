package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.NumericPlanIndicator;
import ru.tehkode.samppy.proto.SMPPCOctet;
import ru.tehkode.samppy.proto.SMPPCommand;
import ru.tehkode.samppy.proto.SMPPInteger;
import ru.tehkode.samppy.proto.TypeOfNumber;

public class QueryBroadcastSM extends AbstractPDU<QueryBroadcastSM> implements MessagePDU<QueryBroadcastSM> {

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

    public QueryBroadcastSM sourceAddrTON(TypeOfNumber sourceAddrTON) {
        this.sourceAddrTON = sourceAddrTON;

        return this;
    }

    public NumericPlanIndicator sourceAddrNPI() {
        return sourceAddrNPI;
    }

    public QueryBroadcastSM sourceAddrNPI(NumericPlanIndicator sourceAddrNPI) {
        this.sourceAddrNPI = sourceAddrNPI;

        return this;
    }

    public String sourceAddr() {
        return sourceAddr;
    }

    public QueryBroadcastSM sourceAddr(String sourceAddr) {
        this.sourceAddr = sourceAddr;

        return this;
    }

    public long commandId() {
        return SMPPCommand.QUERY_BROADCAST_SM.commandId();
    }

    public Class<? extends ResponsePDU> getResponseClass() {
        return QueryBroadcastSMResp.class;
    }
}
