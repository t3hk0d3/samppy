package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.pdu.SubmitSM;
import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.DataCoding;
import ru.tehkode.samppy.proto.NumericPlanIndicator;
import ru.tehkode.samppy.proto.RegisteredDelivery;
import ru.tehkode.samppy.proto.SMPPCOctet;
import ru.tehkode.samppy.proto.SMPPCommand;
import ru.tehkode.samppy.proto.SMPPDate;
import ru.tehkode.samppy.proto.SMPPInteger;
import ru.tehkode.samppy.proto.SMPPOctet;
import ru.tehkode.samppy.proto.TypeOfNumber;

public class ReplaceSM extends AbstractPDU<ReplaceSM> implements MessagePDU<ReplaceSM> {

    @SMPPCOctet(order = 1, maxLength = 65)
    private String messageId;
    @SMPPInteger(order = 2)
    private TypeOfNumber sourceAddrTON;
    @SMPPInteger(order = 3)
    private NumericPlanIndicator sourceAddrNPI;
    @SMPPCOctet(order = 4, maxLength = 21)
    private String sourceAddr;
    @SMPPCOctet(order = 11, maxLength = 17)
    private SMPPDate scheduleDeliveryTime;
    @SMPPCOctet(order = 12, maxLength = 17)
    private SMPPDate validityPeriod;
    @SMPPInteger(order = 13)
    private RegisteredDelivery registeredDelivery;
    @SMPPInteger(order = 16)
    private short smDefaultMsgId;
    @SMPPInteger(order = 17)
    private short smLength;
    @SMPPOctet(order = 18, length = 255, lengthField = "smLength")
    private byte[] shortMessage;

    public String messageId() {
        return messageId;
    }

    public ReplaceSM messageId(String messageId) {
        this.messageId = messageId;

        return this;
    }

    public TypeOfNumber sourceAddrTON() {
        return sourceAddrTON;
    }

    public ReplaceSM sourceAddrTON(TypeOfNumber sourceAddrTON) {
        this.sourceAddrTON = sourceAddrTON;

        return this;
    }

    public NumericPlanIndicator sourceAddrNPI() {
        return sourceAddrNPI;
    }

    public ReplaceSM sourceAddrNPI(NumericPlanIndicator sourceAddrNPI) {
        this.sourceAddrNPI = sourceAddrNPI;

        return this;
    }

    public String sourceAddr() {
        return sourceAddr;
    }
    
     public SMPPDate scheduleDeliveryTime() {
        return scheduleDeliveryTime;
    }

    public ReplaceSM scheduleDeliveryTime(SMPPDate scheduleDeliveryTime) {
        this.scheduleDeliveryTime = scheduleDeliveryTime;
        
        return this;
    }

    public SMPPDate validityPeriod() {
        return validityPeriod;
    }

    public ReplaceSM validityPeriod(SMPPDate validityPeriod) {
        this.validityPeriod = validityPeriod;
        
        return this;
    }

    public RegisteredDelivery registeredDelivery() {
        return registeredDelivery;
    }

    public ReplaceSM registeredDelivery(RegisteredDelivery registeredDelivery) {
        this.registeredDelivery = registeredDelivery;
        
        return this;
    }

    public short smDefaultMsgId() {
        return smDefaultMsgId;
    }

    public ReplaceSM smDefaultMsgId(short smDefaultMsgId) {
        this.smDefaultMsgId = smDefaultMsgId;
        
        return this;
    }

    public short smLength() {
        return smLength;
    }

    public ReplaceSM smLength(short smLength) {
        this.smLength = smLength;
        
        return this;
    }

    public byte[] shortMessage() {
        return shortMessage;
    }

    public ReplaceSM shortMessage(byte[] shortMessage) {
        this.shortMessage = shortMessage;
        
        return this;
    }    

    public long commandId() {
        return SMPPCommand.REPLACE_SM.commandId();
    }

    public Class<? extends ResponsePDU> getResponseClass() {
        return ReplaceSMResp.class;
    }
}
