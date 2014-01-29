package ru.tehkode.samppy.processor;

import java.nio.ByteBuffer;
import java.util.EnumMap;
import ru.tehkode.samppy.proto.PDU;
import ru.tehkode.samppy.proto.SMPPCommand;

public class PDUProcessor {

    private final EnumMap<SMPPCommand, PDUHandler> handlers = new EnumMap<SMPPCommand, PDUHandler>(SMPPCommand.class);

    public PDUProcessor() {
        for (SMPPCommand command : SMPPCommand.values()) {
            handlers.put(command, new PDUHandler(command.getPDUClass()));
        }
    }

    public PDU readPDU(ByteBuffer buffer) {
        int commandId = buffer.getInt();

        return getHandler(commandId).read(buffer);
    }

    public ByteBuffer writePDU(PDU pdu) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024); // 1 KiB buffer should be enough

        PDUHandler handler = getHandler(pdu.commandId());
        
        handler.write(pdu, buffer);
        
        buffer.flip();

        return buffer;
    }

    private PDUHandler getHandler(long commandId) {
        SMPPCommand command = SMPPCommand.byCommandId(commandId);

        return handlers.get(command);
    }
}
