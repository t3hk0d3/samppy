package ru.tehkode.samppy.processor;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import ru.tehkode.samppy.proto.SMPPCOctet;
import ru.tehkode.samppy.proto.SMPPDate;
import ru.tehkode.samppy.proto.SMPPHelper;

class StringFieldHandler extends AbstractFieldHandler {
    private static final Class[] allowedTypes = new Class[]{String.class, SMPPDate.class, byte[].class};
    final int length;

    public StringFieldHandler(int order, Field field) {
        super(order, field);
        this.length = field.getAnnotation(SMPPCOctet.class).maxLength();
        checkAllowedTypes(allowedTypes);
    }

    @Override
    public void serialize(ByteBuffer buffer, Object value) {
        String result = null;
        if (value instanceof String) {
            result = (String) value;
        } else if (value instanceof SMPPDate) {
            result = ((SMPPDate) value).value();
        } else if (value instanceof byte[]) {
            result = new String((byte[]) value);
        }
        SMPPHelper.writeCString(buffer, result, length);
    }

    @Override
    public Object deserialize(ByteBuffer buffer) {
        Class type = field().getType();
        String value = SMPPHelper.readCString(buffer, this.length);
        if (type.isAssignableFrom(String.class)) {
            return value;
        } else if (type.isAssignableFrom(SMPPDate.class)) {
            return new SMPPDate(value);
        } else if (type.isAssignableFrom(byte[].class)) {
            return value.getBytes();
        }
        throw new IllegalArgumentException("Unable to cast c-octet field '" + field().getName() + "' to '" + type.getCanonicalName() + "'");
    }
    
}
