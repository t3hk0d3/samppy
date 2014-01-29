package ru.tehkode.samppy.pdu;

import java.util.Arrays;
import ru.tehkode.samppy.proto.ResponsePDU;
import ru.tehkode.samppy.proto.MessagePDU;
import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.DataCoding;
import ru.tehkode.samppy.proto.Destination;
import ru.tehkode.samppy.proto.Destination.List;
import ru.tehkode.samppy.proto.ESMClass;
import ru.tehkode.samppy.proto.NumericPlanIndicator;
import ru.tehkode.samppy.proto.RegisteredDelivery;
import ru.tehkode.samppy.proto.SMPPCOctet;
import ru.tehkode.samppy.proto.SMPPCommand;
import ru.tehkode.samppy.proto.SMPPComposite;
import ru.tehkode.samppy.proto.SMPPDate;
import ru.tehkode.samppy.proto.SMPPInteger;
import ru.tehkode.samppy.proto.SMPPOctet;
import ru.tehkode.samppy.proto.ShortMessage;
import ru.tehkode.samppy.proto.TypeOfNumber;

public class SubmitMulti extends AbstractPDU<SubmitMulti> implements MessagePDU<SubmitMulti> {

    @SMPPCOctet(order = 1, maxLength = 6)
    private String serviceType;
    @SMPPInteger(order = 2)
    private TypeOfNumber sourceAddrTON;
    @SMPPInteger(order = 3)
    private NumericPlanIndicator sourceAddrNPI;
    @SMPPCOctet(order = 4, maxLength = 21)
    private String sourceAddr;
    @SMPPComposite(order = 5, adapter = Destination.Adapter.class)
    private Destination.List<Destination> destinationList = new Destination.List<Destination>();
    @SMPPInteger(order = 6)
    private ESMClass esmClass;
    @SMPPInteger(order = 7)
    private byte protocolId;
    @SMPPInteger(order = 8)
    private byte priorityFlag;
    @SMPPCOctet(order = 9, maxLength = 17)
    private SMPPDate scheduleDeliveryTime;
    @SMPPCOctet(order = 10, maxLength = 17)
    private SMPPDate validityPeriod;
    @SMPPInteger(order = 11)
    private RegisteredDelivery registeredDelivery;
    @SMPPInteger(order = 12)
    private boolean replaceIfPresent = false;
    @SMPPInteger(order = 13)
    private DataCoding dataCoding;
    @SMPPInteger(order = 14)
    private short smDefaultMsgId;
    @SMPPComposite(order = 15, adapter=ShortMessage.Adapter.class)
    private ShortMessage shortMessage;

    public long commandId() {
        return SMPPCommand.SUBMIT_MULTI.commandId();
    }

    public Class<? extends ResponsePDU> getResponseClass() {
        return SubmitMultiResp.class;
    }

    public String serviceType() {
        return serviceType;
    }

    public SubmitMulti serviceType(String serviceType) {
        this.serviceType = serviceType;

        return this;
    }

    public TypeOfNumber sourceAddrTON() {
        return sourceAddrTON;
    }

    public SubmitMulti sourceAddrTON(TypeOfNumber sourceAddrTON) {
        this.sourceAddrTON = sourceAddrTON;

        return this;
    }

    public NumericPlanIndicator sourceAddrNPI() {
        return sourceAddrNPI;
    }

    public SubmitMulti sourceAddrNPI(NumericPlanIndicator sourceAddrNPI) {
        this.sourceAddrNPI = sourceAddrNPI;

        return this;
    }

    public String sourceAddr() {
        return sourceAddr;
    }

    public SubmitMulti sourceAddr(String sourceAddr) {
        this.sourceAddr = sourceAddr;

        return this;
    }

    public List<Destination> destinationList() {
        return destinationList;
    }

    public SubmitMulti addDestination(Destination... destination) {
        if (this.destinationList == null) {
            this.destinationList = new Destination.List<Destination>();
        }

        this.destinationList.addAll(Arrays.asList(destination));

        return this;
    }

    public SubmitMulti removeDestination(Destination... destination) {
        if (this.destinationList != null) {
            this.destinationList.removeAll(Arrays.asList(destination));
        }

        return this;
    }

    public SubmitMulti destinationList(List<Destination> destinationList) {
        this.destinationList = destinationList;

        return this;
    }

    public ESMClass esmClass() {
        return esmClass;
    }

    public SubmitMulti esmClass(ESMClass esmClass) {
        this.esmClass = esmClass;

        return this;
    }

    public byte protocolId() {
        return protocolId;
    }

    public SubmitMulti protocolId(byte protocolId) {
        this.protocolId = protocolId;

        return this;
    }

    public byte priorityFlag() {
        return priorityFlag;
    }

    public SubmitMulti priorityFlag(byte priorityFlag) {
        this.priorityFlag = priorityFlag;

        return this;
    }

    public SMPPDate scheduleDeliveryTime() {
        return scheduleDeliveryTime;
    }

    public SubmitMulti scheduleDeliveryTime(SMPPDate scheduleDeliveryTime) {
        this.scheduleDeliveryTime = scheduleDeliveryTime;

        return this;
    }

    public SMPPDate validityPeriod() {
        return validityPeriod;
    }

    public SubmitMulti validityPeriod(SMPPDate validityPeriod) {
        this.validityPeriod = validityPeriod;

        return this;
    }

    public RegisteredDelivery registeredDelivery() {
        return registeredDelivery;
    }

    public SubmitMulti registeredDelivery(RegisteredDelivery registeredDelivery) {
        this.registeredDelivery = registeredDelivery;

        return this;
    }

    public boolean replaceIfPresent() {
        return replaceIfPresent;
    }

    public SubmitMulti replaceIfPresent(boolean replaceIfPresent) {
        this.replaceIfPresent = replaceIfPresent;

        return this;
    }

    public DataCoding dataCoding() {
        return dataCoding;
    }

    public SubmitMulti dataCoding(DataCoding dataCoding) {
        this.dataCoding = dataCoding;

        return this;
    }

    public short smDefaultMsgId() {
        return smDefaultMsgId;
    }

    public SubmitMulti smDefaultMsgId(short smDefaultMsgId) {
        this.smDefaultMsgId = smDefaultMsgId;

        return this;
    }

    public ShortMessage shortMessage() {
        return shortMessage;
    }

    public SubmitMulti shortMessage(ShortMessage shortMessage) {
        this.shortMessage = shortMessage;

        return this;
    }
}
