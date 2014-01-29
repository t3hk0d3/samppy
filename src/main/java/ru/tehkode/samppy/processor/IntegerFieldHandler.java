package ru.tehkode.samppy.processor;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import ru.tehkode.samppy.proto.DataCoding;
import ru.tehkode.samppy.proto.ESMClass;
import ru.tehkode.samppy.proto.MessageState;
import ru.tehkode.samppy.proto.NumericPlanIndicator;
import ru.tehkode.samppy.proto.RegisteredDelivery;
import ru.tehkode.samppy.proto.SMPPInteger;
import ru.tehkode.samppy.proto.TypeOfNumber;

class IntegerFieldHandler extends AbstractFieldHandler {
    private static final Class[] allowedTypes = new Class[]{Integer.TYPE, Integer.class, Long.TYPE, Long.class, Short.TYPE, Short.class, Byte.TYPE, Byte.class, TypeOfNumber.class, NumericPlanIndicator.class, ESMClass.class, RegisteredDelivery.class, MessageState.class, DataCoding.class, Boolean.TYPE, Boolean.class};
    final int length;

    public IntegerFieldHandler(int order, Field field) {
        super(order, field);
        this.length = field.getAnnotation(SMPPInteger.class).length();
        checkAllowedTypes(allowedTypes);
    }

    @Override
    public void serialize(ByteBuffer buffer, Object obj) {
        Class type = field().getType();
        byte[] result = new byte[this.length];
        long value = 0;
        if (obj instanceof Number) {
            value = ((Number) obj).longValue();
        }
        if (obj instanceof Byte) {
            value &= 0xFF;
        } else if (obj instanceof Short) {
            value &= 0xFFFF;
        } else if (obj instanceof Integer) {
            value &= 0xFFFFFFFF;
        } else if (obj instanceof TypeOfNumber) {
            value = ((TypeOfNumber) obj).value() & 0xFF;
        } else if (obj instanceof NumericPlanIndicator) {
            value = ((NumericPlanIndicator) obj).value() & 0xFF;
        } else if (obj instanceof ESMClass) {
            value = ((ESMClass) obj).value() & 0xFF;
        } else if (obj instanceof RegisteredDelivery) {
            value = ((RegisteredDelivery) obj).value() & 0xFF;
        } else if (obj instanceof MessageState) {
            value = ((MessageState) obj).value() & 0xFF;
        } else if (obj instanceof DataCoding) {
            value = ((DataCoding) obj).value() & 0xFF;
        } else if (obj instanceof Boolean) {
            value = ((Boolean) obj).booleanValue() ? 1 : 0;
        }
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = (byte) (value & 0xFF);
            value >>= 8;
        }
        buffer.put(result);
    }

    @Override
    public Object deserialize(ByteBuffer buffer) {
        byte[] value = new byte[this.length];
        buffer.get(value);
        BigInteger reader = new BigInteger(value);
        Class type = field().getType();
        if (type.isAssignableFrom(Byte.class) || type.isAssignableFrom(Byte.TYPE)) {
            return reader.byteValue();
        } else if (type.isAssignableFrom(Short.class) || type.isAssignableFrom(Short.TYPE)) {
            return reader.shortValue();
        } else if (type.isAssignableFrom(Integer.class) || type.isAssignableFrom(Integer.TYPE)) {
            return reader.intValue();
        } else if (type.isAssignableFrom(Long.class) || type.isAssignableFrom(Long.TYPE)) {
            return reader.longValue();
        } else if (type.isAssignableFrom(TypeOfNumber.class)) {
            return TypeOfNumber.lookup(reader.byteValue());
        } else if (type.isAssignableFrom(NumericPlanIndicator.class)) {
            return NumericPlanIndicator.lookup(reader.byteValue());
        } else if (type.isAssignableFrom(ESMClass.class)) {
            return new ESMClass(reader.byteValue());
        } else if (type.isAssignableFrom(RegisteredDelivery.class)) {
            return new RegisteredDelivery(reader.byteValue());
        } else if (type.isAssignableFrom(MessageState.class)) {
            return MessageState.lookup(reader.byteValue());
        } else if (type.isAssignableFrom(DataCoding.class)) {
            return new DataCoding(reader.byteValue());
        } else if (type.isAssignableFrom(Boolean.class) || type.isAssignableFrom(Boolean.TYPE)) {
            return reader.byteValue() == 1;
        }
        throw new IllegalArgumentException("Unable to cast integer field '" + field().getName() + "' to '" + type.getCanonicalName() + "'");
    }
    
}
