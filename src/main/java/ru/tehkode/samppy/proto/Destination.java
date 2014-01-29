package ru.tehkode.samppy.proto;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public interface Destination {

    public Type addressType();

    public void write(ByteBuffer buffer);

    public static class List<T extends Destination> extends ArrayList<T> {

        public List(int initialCapacity) {
            super(initialCapacity);
        }

        public List() {
            super();
        }
    }

    public static class Adapter implements SMPPCompositeField<List<Destination>> {

        public List<Destination> deserialize(ByteBuffer buffer) {
            int amount = buffer.get();

            List result = new List<Destination>(amount);

            for (int i = 0; i < amount; i++) {
                result.add(factory(buffer));
            }

            return result;
        }

        public void serialize(ByteBuffer buffer, List<Destination> object) {
            if (object.size() > 255) {
                throw new IllegalStateException("There is more than 255 destinations.");
            }

            buffer.put((byte) object.size());
            for (Destination destination : object) {
                buffer.put(destination.addressType().value());
                destination.write(buffer);
            }
        }

        private Destination factory(ByteBuffer buffer) {
            Type type = Type.lookup(buffer.get());

            switch (type) {
                case SME_ADDRESS:
                    return new SMEAddress(buffer);
                case DISTRIBUTION_LIST:
                    return new DistributionList(buffer);
            }

            // THIS WOULD NOT HAPPEN
            // in fact exception would be thrown on type lookup
            throw new IllegalArgumentException("Unknown destination type (" + type + ")");
        }
    }

    public enum Type {

        SME_ADDRESS(0x01, SMEAddress.class),
        DISTRIBUTION_LIST(0x02, DistributionList.class);
        private final byte value;
        private final Class<? extends Destination> addressClass;

        private Type(int value, Class<? extends Destination> addressClass) {
            this.value = (byte) value;
            this.addressClass = addressClass;
        }

        public byte value() {
            return this.value;
        }

        public Class<? extends Destination> addressClass() {
            return addressClass;
        }

        public static Type lookup(byte value) {
            for (Type type : values()) {
                if (type.value == value) {
                    return type;
                }
            }

            throw new IllegalArgumentException("Unknown address type (" + value + ")");
        }
    }
}
