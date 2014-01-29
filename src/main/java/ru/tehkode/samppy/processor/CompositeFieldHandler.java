package ru.tehkode.samppy.processor;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import ru.tehkode.samppy.proto.SMPPComposite;
import ru.tehkode.samppy.proto.SMPPFieldHandler;

class CompositeFieldHandler extends AbstractFieldHandler {
    private final SMPPFieldHandler fieldHandler;

    public CompositeFieldHandler(int order, Field field) {
        super(order, field);
        Class<? extends SMPPFieldHandler> fieldClass = field.getAnnotation(SMPPComposite.class).adapter();
        try {
            fieldHandler = fieldClass.newInstance();
        } catch (ReflectiveOperationException e) {
            throw new IllegalArgumentException("Composite field handler (" + fieldClass.getCanonicalName() + ") should have open constructior", e);
        }
        // there is no way we could check type compatibility
    }

    @Override
    public void serialize(ByteBuffer buffer, Object value) {
        fieldHandler.serialize(buffer, value);
    }

    @Override
    public Object deserialize(ByteBuffer buffer) {
        return fieldHandler.deserialize(buffer);
    }
    
}
