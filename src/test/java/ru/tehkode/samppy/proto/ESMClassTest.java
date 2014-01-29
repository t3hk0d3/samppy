package ru.tehkode.samppy.proto;

import org.junit.Test;
import static org.junit.Assert.*;

public class ESMClassTest {
    
    @Test
    public void testParsing() {
        ESMClass esmClass = new ESMClass((byte)0xDA);
        
        assertEquals(ESMClass.MessageMode.FORWARD, esmClass.messageMode());
        assertEquals(ESMClass.MessageType.CONVERSATION_ABORT, esmClass.messageType());
        assertEquals(ESMClass.GSMSpecific.BOTH, esmClass.gsmSpecific());
    }
    
    @Test
    public void testSerializtion() {
        ESMClass esmClass = new ESMClass(ESMClass.MessageMode.FORWARD,
                                         ESMClass.MessageType.CONVERSATION_ABORT,
                                         ESMClass.GSMSpecific.BOTH);
        
        assertEquals((byte)0xDA, esmClass.value());
    }
}
