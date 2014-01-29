package ru.tehkode.samppy.proto;

public class ESMClass {
    
    private MessageMode messageMode = MessageMode.DEFAULT;
    private MessageType messageType = MessageType.DEFAULT;
    private GSMSpecific gsmSpecific = GSMSpecific.DEFAULT;

    public ESMClass() {
    }

    public ESMClass(MessageMode mode, MessageType type, GSMSpecific gsm) {
        this.messageMode = mode;
        this.messageType = type;
        this.gsmSpecific = gsm;
    }
    
    public ESMClass(byte value) {
        this(MessageMode.lookup(value),
             MessageType.lookup((byte)(value >> 2)),
             GSMSpecific.lookup((byte)(value >> 6)));
    }

    public MessageMode messageMode() {
        return messageMode;
    }

    public ESMClass messageMode(MessageMode messageMode) {
        this.messageMode = messageMode;
        
        return this;
    }

    public MessageType messageType() {
        return messageType;
    }

    public ESMClass messageMode(MessageType messageType) {
        this.messageType = messageType;
        
        return this;
    }

    public GSMSpecific gsmSpecific() {
        return gsmSpecific;
    }

    public ESMClass messageMode(GSMSpecific gsmSpecific) {
        this.gsmSpecific = gsmSpecific;
        
        return this;
    }
       
    
    public byte value() {
        return (byte)((this.messageMode.value() & 0x03) |
               ((this.messageType.value() & 0x0F) << 2) |
               ((this.gsmSpecific.value() & 0x03) << 6));
    }
    
    public enum MessageMode {
        DEFAULT(0),
        DATAGRAMM(1),
        FORWARD(2),
        STORE_FORWARD(3);
        
        private final byte value;
        
        private MessageMode(int value) {
            this.value = (byte) value;
        }
        
        public byte value() {
            return this.value;
        }
        
        public static MessageMode lookup(byte value) {
            value &= 0x03;
            
            for(MessageMode mode : values()) {
                if(mode.value() == value) {
                    return mode;
                }
            }
            
            throw new IllegalArgumentException("Unknown ESM class message mode (" + value + ")");
        }
    }
    
    public enum MessageType {
        DEFAULT(0),
        DELIVERY_RECEIPT(1),
        DELIVERY_ACKNOWLODGEMENT(2),
        MANUAL_ACKNOWLODGEMENT(4),
        CONVERSATION_ABORT(6),
        DELIVERY_NOTIFICATION(8);
        
        private final byte value;
        
        private MessageType(int value) {
            this.value = (byte) value;
        }
        
        public byte value() {
            return this.value;
        }
        
        public static MessageType lookup(byte value) {
            value &= 0x0F;
            
            for(MessageType mode : values()) {
                if(mode.value() == value) {
                    return mode;
                }
            }
            
            throw new IllegalArgumentException("Unknown ESM class message type (" + value + ")");
        }
    }
    
    public enum GSMSpecific {
        DEFAULT(0),
        UDH_INDICATIOR(1),
        REPLY_PATH(2),
        BOTH(3);
        
        private final byte value;
        
        private GSMSpecific(int value) {
            this.value = (byte) value;
        }
        
        public byte value() {
            return this.value;
        }
        
        public static GSMSpecific lookup(byte value) {
            value &= 0x03;
            
            for(GSMSpecific mode : values()) {
                if(mode.value() == value) {
                    return mode;
                }
            }
            
            throw new IllegalArgumentException("Unknown ESM class gsm bits (" + value + ")");
        }
    }
    
}
