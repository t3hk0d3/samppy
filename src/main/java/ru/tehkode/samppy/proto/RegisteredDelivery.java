package ru.tehkode.samppy.proto;

public class RegisteredDelivery {
    
    private DeliveryReceipt deliveryReceipt = DeliveryReceipt.DEFAULT;
    private SMEAcknowlodgement smeAcknowlodgement = SMEAcknowlodgement.DEFAULT;
    private boolean intermendiateNotification = false;

    public RegisteredDelivery() {
    }

    public RegisteredDelivery(DeliveryReceipt deliveryReceipt, SMEAcknowlodgement smeAcknowlodgement, boolean intermendiateNotification) {
        this.deliveryReceipt = deliveryReceipt;
        this.smeAcknowlodgement = smeAcknowlodgement;
        this.intermendiateNotification = intermendiateNotification;
    }

    public RegisteredDelivery(byte value) {
        this(DeliveryReceipt.lookup(value),
             SMEAcknowlodgement.lookup((byte)(value >> 2)),
             ((value >> 3) & 0x01) == 0x01);
    }

    public DeliveryReceipt deliveryReceipt() {
        return deliveryReceipt;
    }

    public RegisteredDelivery deliveryReceipt(DeliveryReceipt deliveryReceipt) {
        this.deliveryReceipt = deliveryReceipt;
        return this;
    }

    public SMEAcknowlodgement smeAcknowlodgement() {
        return smeAcknowlodgement;
    }

    public RegisteredDelivery smeAcknowlodgement(SMEAcknowlodgement smeAcknowlodgement) {
        this.smeAcknowlodgement = smeAcknowlodgement;
        return this;
    }

    public boolean isIntermendiateNotification() {
        return intermendiateNotification;
    }

    public RegisteredDelivery intermendiateNotification(boolean intermendiateNotification) {
        this.intermendiateNotification = intermendiateNotification;
        return this;
    }
       
    
    public byte value() {
        return (byte)((deliveryReceipt.value() & 0x03) |
                ((smeAcknowlodgement.value & 0x03) << 2) |
                ((intermendiateNotification ? 1 : 0) << 3));
    }
    
    public enum DeliveryReceipt {
        DEFAULT(0),
        SUCCESS_OR_FAILURE(1),
        DELIVERY_FAILURE(2),
        DELIVERY_SUCCESS(3);
        
        private final byte value;
        
        private DeliveryReceipt(int value) {
            this.value = (byte) value;
        }
        
        public byte value() {
            return this.value;
        }
        
        public static DeliveryReceipt lookup(byte value) {
            value &= 0x03;
            
            for(DeliveryReceipt mode : values()) {
                if(mode.value() == value) {
                    return mode;
                }
            }
            
            throw new IllegalArgumentException("Unknown delivery receipt bits (" + value + ")");
        }
    }
    
    public enum SMEAcknowlodgement {
        DEFAULT(0),
        DELIVERY(1),
        MANUAL(2),
        BOTH(3);
        
        private final byte value;
        
        private SMEAcknowlodgement(int value) {
            this.value = (byte) value;
        }
        
        public byte value() {
            return this.value;
        }
        
        public static SMEAcknowlodgement lookup(byte value) {
            value &= 0x03;
            
            for(SMEAcknowlodgement mode : values()) {
                if(mode.value() == value) {
                    return mode;
                }
            }
            
            throw new IllegalArgumentException("Unknown sme acknowlodgement bits (" + value + ")");
        }
    }
    
}
