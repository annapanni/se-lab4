package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class TorpedoStoreTest {
    TorpedoStore hasFive;
    TorpedoStore empty;
    TorpedoStore faultyOne;

    @BeforeEach
    void setup() {
        hasFive = new TorpedoStore(5);
        empty = new TorpedoStore(0);
        faultyOne = new TorpedoStore(1, 1.0);  
    }

    @Test
    void fire_Success() {
        boolean result = hasFive.fire(1);
        assertTrue(result);
    }

    @Test
    void illegalArg() {
        assertThrows(IllegalArgumentException.class, () -> hasFive.fire(-1));
        assertThrows(IllegalArgumentException.class, () -> empty.fire(1));
    }

    @Test
    void testFaulty() {
        assertFalse(faultyOne.fire(1));
    }

    @Test
    void fireMultiple(){
        hasFive.fire(3);
        assertEquals(2, hasFive.getTorpedoCount());
        hasFive.fire(2);
        assertEquals(0, hasFive.getTorpedoCount());
    }

    @Test
    void isEmptyTest() {
        assertTrue(empty.isEmpty()); 
        assertFalse(hasFive.isEmpty()); 
    }


}
