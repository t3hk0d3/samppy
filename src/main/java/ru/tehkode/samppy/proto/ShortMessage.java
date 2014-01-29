package ru.tehkode.samppy.proto;

import java.nio.ByteBuffer;


public class ShortMessage {
    
    private byte[] message;
    
    public ShortMessage() {
    }

    public ShortMessage(byte[] message) {
        this.message = message;
    }   
    
    public byte[] message() {
        return message;
    }

    public ShortMessage message(byte[] message) {
        this.message = message;
        
        return this;
    }
    
    public byte length() {
        return (byte)message.length;
    }
    
    public static class Adapter implements SMPPCompositeField<ShortMessage> {
        public ShortMessage deserialize(ByteBuffer buffer) {
            int length = buffer.get();
            
            byte[] message = new byte[length];
            
            return new ShortMessage(message);
        }

        public void serialize(ByteBuffer buffer, ShortMessage object) {
            buffer.put(object.length());
            buffer.put(object.message());
        }
    }
}
