package ru.tehkode.samppy.proto;

import ru.tehkode.samppy.pdu.*;
import java.util.HashMap;
import java.util.Map;

public enum SMPPCommand {

    BIND_RECEIVER(0x0000000, BindReceiver.class),
    BIND_TRANSMITTER(0x00000002, BindTransmitter.class),
    QUERY_SM(0x00000003, QuerySM.class),
    SUBMIT_SM(0x00000004, SubmitSM.class),
    DELIVER_SM(0x00000005, DeliverSM.class),
    UNBIND(0x00000006, Unbind.class),
    REPLACE_SM(0x00000007, ReplaceSM.class),
    CANCEL_SM(0x00000008, CancelSM.class),
    BIND_TRANSCEIVER(0x00000009, BindTransceiver.class),
    OUTBIND(0x0000000B, Outbind.class),
    ENQUIRE_LINK(0x00000015, EnquireLink.class),
    SUBMIT_MULTI(0x00000021, SubmitSM.class),
    ALERT_NOTIFICATION(0x00000102, AlertNotification.class),
    DATA_SM(0x00000103, DataSM.class),
    BROADCAST_SM(0x00000111, BroadcastSM.class),
    QUERY_BROADCAST_SM(0x00000112, QueryBroadcastSM.class),
    CANCEL_BROADCAST_SM(0x00000113, CancelBroadcastSM.class),
    GENERIC_NACK(0x80000000, GenericNack.class),
    BIND_RECEIVER_RESP(0x80000001, BindReceiverResp.class),
    BIND_TRANSMITTER_RESP(0x80000002, BindTransmitterResp.class),
    QUERY_SM_RESP(0x80000003, QuerySMResp.class),
    SUBMIT_SM_RESP(0x80000004, SubmitSMResp.class),
    DELIVER_SM_RESP(0x80000005, DeliverSM.class),
    UNBIND_RESP(0x80000006, UnbindResp.class),
    REPLACE_SM_RESP(0x80000007, ReplaceSMResp.class),
    CANCEL_SM_RESP(0x80000008, CancelSMResp.class),
    BIND_TRANSCEIVER_RESP(0x80000009, BindTransceiverResp.class),
    ENQUIRE_LINK_RESP(0x80000015, EnquireLinkResp.class),
    SUBMIT_MULTI_RESP(0x80000021, SubmitSMResp.class),
    DATA_SM_RESP(0x80000103, DataSMResp.class),
    BROADCAST_SM_RESP(0x80000111, BroadcastSMResp.class),
    QUERY_BROADCAST_SM_RESP(0x80000112, QueryBroadcastSMResp.class),
    CANCEL_BROADCAST_SM_RESP(0x8000011, CancelBroadcastSMResp.class);
    
    private final static Map<Long, SMPPCommand> commandMap = new HashMap<Long, SMPPCommand>(SMPPCommand.values().length);
    private final static Map<Class<? extends PDU>, SMPPCommand> classMap = new HashMap<Class<? extends PDU>, SMPPCommand>(SMPPCommand.values().length);

    static {
        for (SMPPCommand command : SMPPCommand.values()) {
            commandMap.put(command.commandId(), command);
            classMap.put(command.getPDUClass(), command);
        }
    }
    
    public static SMPPCommand byCommandId(long commandId) {
        if(commandMap.containsKey(commandId)) {
            return commandMap.get(commandId);
        }
        
        throw new IllegalArgumentException("Unknown command_id '" + commandId + "'");
    }

    public static SMPPCommand byPDUClass(Class<? extends PDU> pduClass) {
        if(classMap.containsKey(pduClass)) {
            return classMap.get(pduClass);
        }
        
        throw new IllegalArgumentException("Unknown pdu class '" + pduClass.getCanonicalName() + "'");
    }
    
    private final long commandId;
    private final Class<? extends PDU> pduClass;

    private SMPPCommand(long commandId, Class<? extends PDU> klazz) {
        this.commandId = commandId;
        this.pduClass = klazz;
    }

    public long commandId() {
        return this.commandId;
    }

    public Class<? extends PDU> getPDUClass() {
        return this.pduClass;
    }
}
