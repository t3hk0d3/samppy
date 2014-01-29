package ru.tehkode.samppy.proto;

import java.nio.ByteBuffer;

public class ErrorSMEAddress extends SMEAddress {

    private int errorCode = 0;

    public ErrorSMEAddress() {
    }

    public ErrorSMEAddress(String address, TypeOfNumber ton, NumericPlanIndicator npi) {
        super(address, ton, npi);
    }

    public ErrorSMEAddress(ByteBuffer buffer) {
        super(buffer);
        this.errorCode = buffer.getInt();
    }

    public ErrorSMEAddress(String address) {
        super(address);
    }

    @Override
    public Type addressType() { // defensive programming ftw
        throw new IllegalStateException("Do not use ErrorSMEAddress with for SubmitMultiSM!");
    }   

    public int errorCode() {
        return errorCode;
    }

    public ErrorSMEAddress errorCode(int errorCode) {
        this.errorCode = errorCode;

        return this;
    }

    @Override
    public void write(ByteBuffer buffer) {
        super.write(buffer);
        buffer.putInt(errorCode);
    }

    public static class Adapter implements SMPPCompositeField<Destination.List<ErrorSMEAddress>> {

        public List<ErrorSMEAddress> deserialize(ByteBuffer buffer) {
            int amount = buffer.get();

            List result = new List<ErrorSMEAddress>(amount);

            for (int i = 0; i < amount; i++) {
                result.add(new ErrorSMEAddress(buffer));
            }

            return result;
        }

        public void serialize(ByteBuffer buffer, List<ErrorSMEAddress> object) {
            if (object.size() > 255) {
                throw new IllegalStateException("There is more than 255 destinations.");
            }

            buffer.put((byte) object.size());
            for (ErrorSMEAddress destination : object) {
                destination.write(buffer);           
            }
        }
    }
}
