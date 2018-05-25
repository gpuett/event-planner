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
                System.out.println("Great! Now choose from our catering option: Pizza, Burgers, or Full Catering");
                String food = bufferedReader.readLine().toLowerCase();
                party.setFoodOrdered(food);
                party.setFoodCost();
                System.out.println("Yum! What about drinks? Which would you like of the following? Soda, Craft Beer, or Full Bar?");
                String drink = bufferedReader.readLine().toLowerCase();
                party.setDrinksOrdered(drink);
                party.setDrinkCost();
                System.out.println("Sounds good! What type of musical entertainment would you like? DJ or Band?");
                String entertainer = bufferedReader.readLine().toLowerCase();
                party.setEntertainment(entertainer);
                party.setEntertainmentCost();
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
