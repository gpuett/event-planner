package models;

public class Event {
    private int guestCount;
    private String foodOrdered;
    private String drinksOrdered;
    private String entertainment;
    private int foodCost;

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
        if (this.foodOrdered.equals("Pizza")){
            this.foodCost = this.guestCount * 3;
        } else if (this.foodOrdered.equals("Burgers")){
            this.foodCost = this.guestCount * 5;
        } else if (this.foodOrdered.equals("Full Catering")){
            this.foodCost = this.guestCount * 10;
        }
    }

    public int getFoodCost() {
        return foodCost;
    }

//    public int calculateEventCost() {
//        return 0;
//    }


}
