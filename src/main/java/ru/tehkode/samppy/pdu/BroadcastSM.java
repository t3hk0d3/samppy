package ru.tehkode.samppy.pdu;

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
import ru.tehkode.samppy.proto.TypeOfNumber;

public class BroadcastSM extends AbstractPDU<BroadcastSM> implements MessagePDU<BroadcastSM> {

    @SMPPCOctet(order = 1, maxLength = 6)
    private String serviceType;
    @SMPPInteger(order = 2)
    private TypeOfNumber sourceAddrTON;
    @SMPPInteger(order = 3)
    private NumericPlanIndicator sourceAddrNPI;
    @SMPPCOctet(order = 4, maxLength = 21)
    private String sourceAddr;
    @SMPPCOctet(order = 5, maxLength = 65)
    private String message_id;
    @SMPPInteger(order = 6)
    private byte priorityFlag;
    @SMPPCOctet(order = 7, maxLength = 17)
    private SMPPDate scheduleDeliveryTime;
    @SMPPCOctet(order = 8, maxLength = 17)
    private SMPPDate validityPeriod;
    @SMPPInteger(order = 10)
    private boolean replaceIfPresent = false;
    @SMPPInteger(order = 11)
    private DataCoding dataCoding;
    @SMPPInteger(order = 12)
    private short smDefaultMsgId;

    public long commandId() {
        return SMPPCommand.BROADCAST_SM.commandId();
    }

    public Class<? extends ResponsePDU> getResponseClass() {
        return BroadcastSMResp.class;
    }
}
