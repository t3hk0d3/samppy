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

public class CancelSM extends AbstractPDU<CancelSM> implements MessagePDU<CancelSM> {

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
    @SMPPInteger(order = 6)
    private TypeOfNumber destAddrTON;
    @SMPPInteger(order = 7)
    private NumericPlanIndicator destAddrNPI;
    @SMPPCOctet(order = 8, maxLength = 21)
    private String destAddr;

    public String messageId() {
        return messageId;
    }

    public CancelSM messageId(String messageId) {
        this.messageId = messageId;

        return this;
    }

    public TypeOfNumber sourceAddrTON() {
        return sourceAddrTON;
    }

    public CancelSM sourceAddrTON(TypeOfNumber sourceAddrTON) {
        this.sourceAddrTON = sourceAddrTON;

        return this;
    }

    public NumericPlanIndicator sourceAddrNPI() {
        return sourceAddrNPI;
    }

    public CancelSM sourceAddrNPI(NumericPlanIndicator sourceAddrNPI) {
        this.sourceAddrNPI = sourceAddrNPI;

        return this;
    }

    public String sourceAddr() {
        return sourceAddr;
    }

    public CancelSM sourceAddr(String sourceAddr) {
        this.sourceAddr = sourceAddr;

        return this;
    }

    public TypeOfNumber destAddrTON() {
        return destAddrTON;
    }

    public CancelSM destAddrTON(TypeOfNumber destAddrTON) {
        this.destAddrTON = destAddrTON;

        return this;
    }

    public NumericPlanIndicator destAddrNPI() {
        return destAddrNPI;
    }

    public CancelSM destAddrNPI(NumericPlanIndicator destAddrNPI) {
        this.destAddrNPI = destAddrNPI;

        return this;
    }

    public String destAddr() {
        return destAddr;
    }

    public CancelSM destAddr(String destAddr) {
        this.destAddr = destAddr;

        return this;
    }

    public String serviceType() {
        return serviceType;
    }

    public CancelSM serviceType(String serviceType) {
        this.serviceType = serviceType;

        return this;
    }

    public long commandId() {
        return SMPPCommand.CANCEL_SM.commandId();
    }

    public Class<? extends ResponsePDU> getResponseClass() {
        return CancelSMResp.class;
    }
}
