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

    @Test
    public void getFoodOrdered_correctlyGetsFoodOrder_String() {
        Event testEvent = new Event();
        testEvent.setFoodOrdered("Pizza");
        assertEquals("Pizza", testEvent.getFoodOrdered());
    }

    @Test
    public void getDrinksOrdered_correctlyGetsDrinkOrder_String() {
        Event testEvent = new Event();
        testEvent.setDrinksOrdered("Craft Beer");
        assertEquals("Craft Beer", testEvent.getDrinksOrdered());
    }

    @Test
    public void getEntertainment_correctlyGetsEntertainment_String() {
        Event testEvent = new Event();
        testEvent.setEntertainment("DJ");
        assertEquals("DJ", testEvent.getEntertainment());
    }

    @Test
    public void getFoodCost_calculatesCostOfFood_Integer() {
        Event testEvent = new Event();
        testEvent.setGuestCount(50);
        testEvent.setFoodOrdered("Pizza");
        testEvent.setFoodCost();
        assertEquals(150, testEvent.getFoodCost());
    }

    @Test
    public void getDrinkCost_calculatesCostOfDrinks_Integer() {
        Event testEvent = new Event();
        testEvent.setGuestCount(50);
        testEvent.setDrinksOrdered("Craft Beer");
        testEvent.setDrinkCost();
        assertEquals(200, testEvent.getDrinkCost());
    }

    //    @Test
//    public void calculateEventCost_calculatesCostofEvent_Integer() {
//        Event testEvent = new Event();
//        testEvent.setGuestCount(50);
//        testEvent.setFoodOrdered("Pizza");
//        testEvent.setDrinksOrdered("Craft Beer");
//        testEvent.setEntertainment("DJ");
//        assertEquals(500, testEvent.calculateCost());
//    }
}