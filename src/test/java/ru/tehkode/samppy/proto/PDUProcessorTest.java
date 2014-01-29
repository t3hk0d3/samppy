package ru.tehkode.samppy.proto;

import ru.tehkode.samppy.processor.PDUHandler;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.Arrays;
import org.junit.Test;
import ru.tehkode.samppy.pdu.SubmitSM;

public class PDUProcessorTest {

    @Test
    public void testThing() throws Throwable {

        PDUHandler pduProcessor = new PDUHandler(SubmitSM.class);
        
        

    }
}
