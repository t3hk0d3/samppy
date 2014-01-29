package ru.tehkode.samppy.processor;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import ru.tehkode.samppy.proto.BasicOptionalParameter;
import ru.tehkode.samppy.proto.OptionalParameter;
import ru.tehkode.samppy.proto.PDU;
import ru.tehkode.samppy.proto.SMPPCOctet;
import ru.tehkode.samppy.proto.SMPPComposite;
import ru.tehkode.samppy.proto.SMPPInteger;

public class PDUHandler<T extends PDU> implements Comparator<PDUFieldHandler> {

    private final Class<T> pduClass;
    private final List<PDUFieldHandler> fields = new ArrayList<PDUFieldHandler>();

    public PDUHandler(Class<T> pduClass) {
        this.pduClass = pduClass;

        compileHandlers(this.pduClass);
        Collections.sort(fields, this);

        System.out.println(fields);
    }

    private void compileHandlers(Class klass) {
        if (klass == null || klass.equals(Object.class)) {
            return;
        }

        for (Field field : klass.getDeclaredFields()) {
            if (field.isAnnotationPresent(SMPPCOctet.class)) {
                fields.add(new StringFieldHandler(field.getAnnotation(SMPPCOctet.class).order(), field));
            } else if (field.isAnnotationPresent(SMPPInteger.class)) {
                fields.add(new IntegerFieldHandler(field.getAnnotation(SMPPInteger.class).order(), field));
            } else if (field.isAnnotationPresent(SMPPComposite.class)) {
                fields.add(new CompositeFieldHandler(field.getAnnotation(SMPPComposite.class).order(), field));
            }
        }

        compileHandlers(klass.getSuperclass());
    }

    public T read(ByteBuffer buffer) {
        try {
            T obj = pduClass.newInstance();

            // read PDU header (command_id was already read)
            obj.commandStatus(buffer.getInt());
            obj.sequenceNumber(buffer.getInt());

            // read PDU specific fields
            for (PDUFieldHandler field : fields) {
                try {
                    field.read(obj, buffer);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to set field " + field.field().getName(), e);
                }
            }

            // read optional TLVs
            while (buffer.hasRemaining()) {
                short tag = buffer.getShort();
                short length = buffer.getShort();
                byte[] data = new byte[length];

                buffer.get(data);

                obj.addOptionalParameter(new BasicOptionalParameter(tag, data));
            }

            return obj;
        } catch (ReflectiveOperationException ex) {
            throw new IllegalStateException("Unable to instance new object of '" + pduClass.getCanonicalName() + "'", ex);
        }
    }

    public void write(T obj, ByteBuffer buffer) {
        // write PDU header
        buffer.putInt((int) obj.commandId());
        buffer.putInt((int) obj.commandStatus());
        buffer.putInt((int) obj.sequenceNumber());

        // write PDU specific fields
        for (PDUFieldHandler field : fields) {
            try {
                field.write(buffer, obj);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Failed to get field " + field.field().getName(), e);
            }
        }
                
        for(OptionalParameter param : (Set<OptionalParameter>)obj.optionalParameters()) {
            if(param == null) {
                continue;
            }
            
            buffer.putShort(param.tag());
            buffer.putShort(param.length());
            buffer.put(param.value());
        }
    }

    public int compare(PDUFieldHandler o1, PDUFieldHandler o2) {
        return o1.order() - o2.order();
    }
}
