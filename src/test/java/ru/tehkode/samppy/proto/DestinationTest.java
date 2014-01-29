package ru.tehkode.samppy.proto;

import java.nio.ByteBuffer;
import org.junit.Test;
import static org.junit.Assert.*;

public class DestinationTest {
    
    private final static byte[] testData = new byte[] { 
        3, // amount of entries
        1, 0, 0, 116, 101, 115, 116, 0, // sme/Unknown/unknown/test
        1, 1, 2, 116, 101, 115, 116, 50, 0, // sme/Internationa/DATA/test2
        2, 116, 101, 115, 116, 95, 108, 105, 115, 116, 0 // dl / test_list
    };
    
    private Destination.Adapter adapter = new Destination.Adapter();
    
    @Test
    public void testSerializtion() {
        ByteBuffer testBuffer = ByteBuffer.allocate(testData.length);
        Destination.List list = new Destination.List();
        
        list.add(new SMEAddress("test", TypeOfNumber.UNKNOWN, NumericPlanIndicator.UNKNOWN));
        list.add(new SMEAddress("test2", TypeOfNumber.INTERNATIONAL, NumericPlanIndicator.DATA));
        list.add(new DistributionList("test_list"));
        
        adapter.serialize(testBuffer, list);
        
        assertArrayEquals(testData, testBuffer.array());        
    }
    
    @Test
    public void testDeserialization() {
        ByteBuffer buffer = ByteBuffer.wrap(testData);
        
        
        
        Destination.List list = adapter.deserialize(buffer);
        
        assertEquals(3, list.size());
        
        Destination dest = list.get(0);
        
        assertEquals(Destination.Type.SME_ADDRESS, dest.addressType());
        
        SMEAddress address = (SMEAddress)dest;
        assertEquals(TypeOfNumber.UNKNOWN, address.addressTON());
        assertEquals(NumericPlanIndicator.UNKNOWN, address.addressNPI());
        assertEquals("test", address.address());
        
        dest = list.get(1);
        
        assertEquals(Destination.Type.SME_ADDRESS, dest.addressType());
        
        address = (SMEAddress)dest;
        assertEquals(TypeOfNumber.INTERNATIONAL, address.addressTON());
        assertEquals(NumericPlanIndicator.DATA, address.addressNPI());
        assertEquals("test2", address.address());
        
        dest = list.get(2);
        
        assertEquals(Destination.Type.DISTRIBUTION_LIST, dest.addressType());
        
        DistributionList dl = (DistributionList)dest;
        assertEquals("test_list", dl.listName());
        
        
    }
}
