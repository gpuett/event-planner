package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EventTest {

    @Test
    public void newEvent_instantiatesCorrectly_true() throws Exception{
        Event testEvent = new Event();
        assertEquals(true, testEvent instanceof Event);
    }

    @Test
    public void getGuestCount_correctlyGetsGuestCount_integer() {
        Event testEvent = new Event();
        testEvent.setGuestCount(50);
        assertEquals(50, testEvent.getGuestCount());

    }
}