package ru.tehkode.samppy.proto;

import org.junit.Test;
import static org.junit.Assert.*;
import ru.tehkode.samppy.proto.SMPPDate.Sign;

/**
 *
 * @author t3hk0d3
 */
public class SMPPDateTest {
    
    @Test
    public void testParser() {
        SMPPDate date = new SMPPDate("130128101752404+");
        
        assertEquals(13, date.year());
        assertEquals(01, date.month());
        assertEquals(28, date.day());
        assertEquals(10, date.hour());
        assertEquals(17, date.minute());
        assertEquals(52, date.second());
        assertEquals(4, date.subsecond());
        assertEquals(4, date.timezone());
        assertEquals(Sign.AFTER, date.sign());
    }
    
    @Test
    public void testEpochSerialization() {
        long expected = 1359353872400L;
        
        SMPPDate date = new SMPPDate("130128101752404+");
        
        assertEquals(expected, date.toTime());
    }
    
    @Test
    public void testEpochDeserialization() {
        SMPPDate date = SMPPDate.fromTime(1359353872400L);
        
        assertEquals(13, date.year());
        assertEquals(01, date.month());
        assertEquals(28, date.day());
        assertEquals(10, date.hour());
        assertEquals(17, date.minute());
        assertEquals(52, date.second());
        assertEquals(4, date.subsecond());
    }
    
    @Test
    public void testSMPPSerialization() {
        SMPPDate date = SMPPDate.fromTime(1359353872400L);
        
        assertEquals("130128101752404+", date.value());
    }
    
     @Test
    public void testYearCutoff() {
        SMPPDate date = new SMPPDate();
        
        date.year(2013);
        
        assertEquals(13, date.year());
        
        date.year(1998);
        
        assertEquals(98, date.year());
        
        date.year(12);
        
        assertEquals(12, date.year());
    }
    
    
}
