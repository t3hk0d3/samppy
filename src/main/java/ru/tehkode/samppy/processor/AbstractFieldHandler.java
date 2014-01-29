package ru.tehkode.samppy.processor;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import ru.tehkode.samppy.proto.SMPPFieldHandler;

public abstract class AbstractFieldHandler implements PDUFieldHandler, SMPPFieldHandler<Object> {
    final Field field;
    final int order;

    public AbstractFieldHandler(int order, Field field) {
        this.field = field;
        this.order = order;
        this.field.setAccessible(true);
    }

    public Field field() {
        return this.field;
    }

    public int order() {
        return this.order;
    }

    public void read(Object obj, ByteBuffer buffer) throws IllegalAccessException, IllegalArgumentException {
        field.set(obj, deserialize(buffer));
    }

    public void write(ByteBuffer buffer, Object obj) throws IllegalAccessException, IllegalArgumentException {
        this.serialize(buffer, field.get(obj));
    }

    public Class<Object> fieldClass() {
        return Object.class;
    }

    protected final void checkAllowedTypes(Class... allowedTypes) {
        Class fieldType = field.getType();
        for (Class type : allowedTypes) {
            if (fieldType.isAssignableFrom(type)) {
                return;
            }
        }
        throw new IllegalStateException("Unsupported field (" + field().getName() + ") type (" + fieldType.getCanonicalName() + ")");
    }

    @Override
    public String toString() {
        return "<" + this.getClass().getSimpleName() + " order='" + order + "' field='" + field.getName() + "'>";
    }
    
}
