import models.Event;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the PDX Event Planner App!");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean planning = true;
        while (planning){
            try {
                Event party = new Event();
                System.out.println("How many guests do you expect to attend your event?");
                Integer guests = Integer.parseInt(bufferedReader.readLine());
                party.setGuestCount(guests);
                System.out.println("Now choose from our catering option: Pizza, Burgers, or Full Catering");
                boolean choosingFood = true;
                while (choosingFood) {
                    String food = bufferedReader.readLine().toLowerCase();
                    if (food.equals("pizza") || food.equals("burgers") || food.equals("full catering")){
                        party.setFoodOrdered(food);
                        party.setFoodCost();
                        choosingFood = false;
                    } else {
                        System.out.println("I didn't recognize that entry. Please choose one of the above options.");
                    }
                }
                System.out.println("Yum! What about drinks? Which would you like of the following? Soda, Craft Beer, or Full Bar?");
                boolean choosingdrinks = true;
                while (choosingdrinks){
                    String drink = bufferedReader.readLine().toLowerCase();
                    if (drink.equals("soda") || drink.equals("craft beer") || drink.equals("full bar")){
                        party.setDrinksOrdered(drink);
                        party.setDrinkCost();
                        choosingdrinks = false;
                    } else {
                        System.out.println("I didn't recognize that entry. Please choose one of the above options.");
                    }
                }
                System.out.println("Sounds good! What type of musical entertainment would you like? DJ, Band, or none?");
                boolean choosingEntertainment = true;
                while (choosingEntertainment){
                    String entertainer = bufferedReader.readLine().toLowerCase();
                    if (entertainer.equals("dj") || entertainer.equals("band") || entertainer.equals("none")){
                        party.setEntertainment(entertainer);
                        party.setEntertainmentCost();
                        choosingEntertainment = false;
                    } else {
                        System.out.println("I didn't recognize that entry. Please choose one of the above options.");
                    }
                }
                party.setEventCost();
                System.out.println("That will be fun!");
                System.out.println("The cost of your event will be: $" + party.getEventCost() + ".");
                System.out.println("We hope you enjoy your party! Goodbye!");
                planning = false;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
