package test;

import org.junit.jupiter.api.Test;
import tasks.Producer;

import static org.junit.jupiter.api.Assertions.*;

class ProducerTest {

    @Test
    void testToString() {
        Producer producer = new Producer("Mercedes");
        assertEquals(producer.toString(),"Mercedes");
    }
}