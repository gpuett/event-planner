package models;

public class Event {
    private int guestCount;
    private String foodOrdered;
    private String drinksOrdered;
    private String entertainment;
    private int foodCost;
    private int drinkCost;
    private int entertainmentCost;
    private double eventCost;

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

    public void setEntertainment(String act){
        this.entertainment = act;
    }

    public String getEntertainment() {
        return entertainment;
    }

    public void setFoodCost(){
        if (this.foodOrdered.equals("pizza")){
            this.foodCost = this.guestCount * 3;
        } else if (this.foodOrdered.equals("burgers")){
            this.foodCost = this.guestCount * 5;
        } else if (this.foodOrdered.equals("full catering")){
            this.foodCost = this.guestCount * 10;
        }
    }

    public int getFoodCost() {
        return foodCost;
    }

    public void setDrinkCost(){
        if (this.drinksOrdered.equals("soda")){
            this.drinkCost = this.guestCount;
        } else if (this.drinksOrdered.equals("craft beer")){
            this.drinkCost = this.guestCount * 4;
        } else if (this.drinksOrdered.equals("full bar")){
            this.drinkCost = this.guestCount * 8;
        }
    }

    public int getDrinkCost() {
        return drinkCost;
    }

    public void setEntertainmentCost(){
        if (this.entertainment.equals("dj")){
            this.entertainmentCost = 100;
        } else if (this.entertainment.equals("band")){
            this.entertainmentCost = 200;
        } else if (this.entertainment.equals("none")){
            this.entertainmentCost = 0;
        }
    }

    public int getEntertainmentCost() {
        return entertainmentCost;
    }

    public void setEventCost() {
        this.eventCost = this.foodCost + this.drinkCost + this.entertainmentCost;
    }

    public double getEventCost() {
        return eventCost;
    }


}
