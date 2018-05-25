package models;

public class Event {
    private int guestCount;
    private String foodOrdered;
    private String drinksOrdered;
    private String entertainment;

    public void setGuestCount(int count) {
        this.guestCount = count;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setFoodOrdered(String food){
        this.foodOrdered = food;
    }

    public String getFoodOrdered() {
        return foodOrdered;
    }

    public void setDrinksOrdered(String drink){
        this.drinksOrdered = drink;
    }

    public String getDrinksOrdered() {
        return drinksOrdered;
    }


}
