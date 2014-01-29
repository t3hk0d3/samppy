package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.DataCoding;
import ru.tehkode.samppy.proto.ESMClass;
import ru.tehkode.samppy.proto.NumericPlanIndicator;
import ru.tehkode.samppy.proto.RegisteredDelivery;
import ru.tehkode.samppy.proto.SMPPCOctet;
import ru.tehkode.samppy.proto.SMPPCommand;
import ru.tehkode.samppy.proto.SMPPDate;
import ru.tehkode.samppy.proto.SMPPInteger;
import ru.tehkode.samppy.proto.SMPPOctet;
import ru.tehkode.samppy.proto.TypeOfNumber;

public class DeliverSM extends AbstractPDU<DeliverSM> implements MessagePDU<DeliverSM> {
    
    @SMPPCOctet(order = 1, maxLength = 6)
    private String serviceType;
    @SMPPInteger(order = 2)
    private TypeOfNumber sourceAddrTON;
    @SMPPInteger(order = 3)
    private NumericPlanIndicator sourceAddrNPI;
    @SMPPCOctet(order = 4, maxLength = 21)
    private String sourceAddr;
    @SMPPInteger(order = 5)
    private TypeOfNumber destAddrTON;
    @SMPPInteger(order = 6)
    private NumericPlanIndicator destAddrNPI;
    @SMPPCOctet(order = 7, maxLength = 21)
    private String destAddr;
    @SMPPInteger(order = 8)
    private ESMClass esmClass;
    @SMPPInteger(order = 9)
    private byte protocolId;
    @SMPPInteger(order = 10)
    private byte priorityFlag;
    @SMPPCOctet(order = 11, maxLength= 17)
    private SMPPDate scheduleDeliveryTime;
    @SMPPCOctet(order = 12, maxLength= 17)
    private SMPPDate validityPeriod;
    @SMPPInteger(order = 13)
    private RegisteredDelivery registeredDelivery;
    @SMPPInteger(order = 14)
    private boolean replaceIfPresent = false;
    @SMPPInteger(order = 15)
    private DataCoding dataCoding;
    @SMPPInteger(order = 16)
    private short smDefaultMsgId;
    @SMPPInteger(order = 17)
    private short smLength;    
    @SMPPOctet(order = 18, length = 255, lengthField = "smLength")
    private byte[] shortMessage;
    
     public String serviceType() {
        return serviceType;
    }

    public DeliverSM serviceType(String serviceType) {
        this.serviceType = serviceType;
        
        return this;
    }

    public TypeOfNumber sourceAddrTON() {
        return sourceAddrTON;
    }

    public DeliverSM sourceAddrTON(TypeOfNumber sourceAddrTON) {
        this.sourceAddrTON = sourceAddrTON;
        
        return this;
    }

    public NumericPlanIndicator sourceAddrNPI() {
        return sourceAddrNPI;
    }

    public DeliverSM sourceAddrNPI(NumericPlanIndicator sourceAddrNPI) {
        this.sourceAddrNPI = sourceAddrNPI;
        
        return this;
    }

    public String sourceAddr() {
        return sourceAddr;
    }

    public DeliverSM sourceAddr(String sourceAddr) {
        this.sourceAddr = sourceAddr;
        
        return this;
    }

    public TypeOfNumber destAddrTON() {
        return destAddrTON;
    }

    public DeliverSM destAddrTON(TypeOfNumber destAddrTON) {
        this.destAddrTON = destAddrTON;
        
        return this;
    }

    public NumericPlanIndicator destAddrNPI() {
        return destAddrNPI;
    }

    public DeliverSM destAddrNPI(NumericPlanIndicator destAddrNPI) {
        this.destAddrNPI = destAddrNPI;
        
        return this;
    }

    public String destAddr() {
        return destAddr;
    }

    public DeliverSM destAddr(String destAddr) {
        this.destAddr = destAddr;
        
        return this;
    }

    public ESMClass esmClass() {
        return esmClass;
    }

    public DeliverSM esmClass(ESMClass esmClass) {
        this.esmClass = esmClass;
        
        return this;
    }

    public byte protocolId() {
        return protocolId;
    }

    public DeliverSM protocolId(byte protocolId) {
        this.protocolId = protocolId;
        
        return this;
    }

    public byte priorityFlag() {
        return priorityFlag;
    }

    public DeliverSM priorityFlag(byte priorityFlag) {
        this.priorityFlag = priorityFlag;
        
        return this;
    }

    public SMPPDate scheduleDeliveryTime() {
        return scheduleDeliveryTime;
    }

    public DeliverSM scheduleDeliveryTime(SMPPDate scheduleDeliveryTime) {
        this.scheduleDeliveryTime = scheduleDeliveryTime;
        
        return this;
    }

    public SMPPDate validityPeriod() {
        return validityPeriod;
    }

    public DeliverSM validityPeriod(SMPPDate validityPeriod) {
        this.validityPeriod = validityPeriod;
        
        return this;
    }

    public RegisteredDelivery registeredDelivery() {
        return registeredDelivery;
    }

    public DeliverSM registeredDelivery(RegisteredDelivery registeredDelivery) {
        this.registeredDelivery = registeredDelivery;
        
        return this;
    }

    public boolean replaceIfPresent() {
        return replaceIfPresent;
    }

    public DeliverSM replaceIfPresent(boolean replaceIfPresent) {
        this.replaceIfPresent = replaceIfPresent;
        
        return this;
    }

    public DataCoding dataCoding() {
        return dataCoding;
    }

    public DeliverSM dataCoding(DataCoding dataCoding) {
        this.dataCoding = dataCoding;
        
        return this;
    }

    public short smDefaultMsgId() {
        return smDefaultMsgId;
    }

    public DeliverSM smDefaultMsgId(short smDefaultMsgId) {
        this.smDefaultMsgId = smDefaultMsgId;
        
        return this;
    }

    public short smLength() {
        return smLength;
    }

    public DeliverSM smLength(short smLength) {
        this.smLength = smLength;
        
        return this;
    }

    public byte[] shortMessage() {
        return shortMessage;
    }

    public DeliverSM shortMessage(byte[] shortMessage) {
        this.shortMessage = shortMessage;
        
        return this;
    }

    public long commandId() {
        return SMPPCommand.DELIVER_SM.commandId();
    }

    public Class<? extends ResponsePDU> getResponseClass() {
        return DeliverSMResp.class;
    }
}
