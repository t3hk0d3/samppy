package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.NumericPlanIndicator;
import ru.tehkode.samppy.proto.SMPPCOctet;
import ru.tehkode.samppy.proto.SMPPCommand;
import ru.tehkode.samppy.proto.SMPPInteger;
import ru.tehkode.samppy.proto.TypeOfNumber;

public class CancelBroadcastSM extends AbstractPDU<CancelBroadcastSM> implements MessagePDU<CancelBroadcastSM> {

    @SMPPCOctet(order = 1, maxLength = 6)
    private String serviceType;
    @SMPPCOctet(order = 2, maxLength = 65)
    private String messageId;
    @SMPPInteger(order = 3)
    private TypeOfNumber sourceAddrTON;
    @SMPPInteger(order = 4)
    private NumericPlanIndicator sourceAddrNPI;
    @SMPPCOctet(order = 5, maxLength = 21)
    private String sourceAddr;

    public String messageId() {
        return messageId;
    }

    public CancelBroadcastSM messageId(String messageId) {
        this.messageId = messageId;

        return this;
    }

    public TypeOfNumber sourceAddrTON() {
        return sourceAddrTON;
    }

    public CancelBroadcastSM sourceAddrTON(TypeOfNumber sourceAddrTON) {
        this.sourceAddrTON = sourceAddrTON;

        return this;
    }

    public NumericPlanIndicator sourceAddrNPI() {
        return sourceAddrNPI;
    }

    public CancelBroadcastSM sourceAddrNPI(NumericPlanIndicator sourceAddrNPI) {
        this.sourceAddrNPI = sourceAddrNPI;

        return this;
    }

    public String sourceAddr() {
        return sourceAddr;
    }

    public CancelBroadcastSM sourceAddr(String sourceAddr) {
        this.sourceAddr = sourceAddr;

        return this;
    }

    public String serviceType() {
        return serviceType;
    }

    public CancelBroadcastSM serviceType(String serviceType) {
        this.serviceType = serviceType;

        return this;
    }

    public long commandId() {
        return SMPPCommand.CANCEL_BROADCAST_SM.commandId();
    }

    public Class<? extends ResponsePDU> getResponseClass() {
        return CancelBroadcastSMResp.class;
    }
}
