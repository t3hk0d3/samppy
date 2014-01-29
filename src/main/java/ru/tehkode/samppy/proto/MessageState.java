package ru.tehkode.samppy.proto;

public enum MessageState {

    SCHEDULED(0),
    ENROUTE(1),
    DELIVERED(2),
    EXPIRED(3),
    DELETED(4),
    UNDELIVERABLE(5),
    ACCEPTED(6),
    UNKNOWN(7),
    REJECTED(8),
    SKIPPED(9);
    
    private final byte value;

    private MessageState(int value) {
        this.value = (byte) value;
    }

    public byte value() {
        return value;
    }

    public static MessageState lookup(byte value) {
        for (MessageState state : values()) {
            if (state.value() == value) {
                return state;
            }
        }

        throw new IllegalArgumentException("Unknown message state (" + value + ")");
    }
}
