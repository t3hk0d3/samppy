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
import ru.tehkode.samppy.proto.SMPPInteger;
import ru.tehkode.samppy.proto.TypeOfNumber;

public class DataSM extends AbstractPDU<DataSM> implements MessagePDU<DataSM> {

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
    private RegisteredDelivery registeredDelivery;
    @SMPPInteger(order = 10)
    private DataCoding dataCoding;

    public long commandId() {
        return SMPPCommand.DATA_SM.commandId();
    }

    public Class<? extends ResponsePDU> getResponseClass() {
        return DataSMResp.class;
    }
    
    public String serviceType() {
        return serviceType;
    }

    public DataSM serviceType(String serviceType) {
        this.serviceType = serviceType;
        
        return this;
    }

    public TypeOfNumber sourceAddrTON() {
        return sourceAddrTON;
    }

    public DataSM sourceAddrTON(TypeOfNumber sourceAddrTON) {
        this.sourceAddrTON = sourceAddrTON;
        
        return this;
    }

    public NumericPlanIndicator sourceAddrNPI() {
        return sourceAddrNPI;
    }

    public DataSM sourceAddrNPI(NumericPlanIndicator sourceAddrNPI) {
        this.sourceAddrNPI = sourceAddrNPI;
        
        return this;
    }

    public String sourceAddr() {
        return sourceAddr;
    }

    public DataSM sourceAddr(String sourceAddr) {
        this.sourceAddr = sourceAddr;
        
        return this;
    }

    public TypeOfNumber destAddrTON() {
        return destAddrTON;
    }

    public DataSM destAddrTON(TypeOfNumber destAddrTON) {
        this.destAddrTON = destAddrTON;
        
        return this;
    }

    public NumericPlanIndicator destAddrNPI() {
        return destAddrNPI;
    }

    public DataSM destAddrNPI(NumericPlanIndicator destAddrNPI) {
        this.destAddrNPI = destAddrNPI;
        
        return this;
    }

    public String destAddr() {
        return destAddr;
    }

    public DataSM destAddr(String destAddr) {
        this.destAddr = destAddr;
        
        return this;
    }

    public ESMClass esmClass() {
        return esmClass;
    }

    public DataSM esmClass(ESMClass esmClass) {
        this.esmClass = esmClass;
        
        return this;
    }

    public RegisteredDelivery registeredDelivery() {
        return registeredDelivery;
    }

    public DataSM registeredDelivery(RegisteredDelivery registeredDelivery) {
        this.registeredDelivery = registeredDelivery;
        
        return this;
    }

    public DataCoding dataCoding() {
        return dataCoding;
    }

    public DataSM dataCoding(DataCoding dataCoding) {
        this.dataCoding = dataCoding;
        
        return this;
    }
}
