import models.Event;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.text.NumberFormat;


public class App {
    public static void main(String[] args) {

        Event wedding = new Event();
        wedding.setGuestCount(75);
        wedding.setFoodOrdered("full catering");
        wedding.setDrinksOrdered("full bar");
        wedding.setEntertainment("dj");
        wedding.setPackageCost(1200);

        Event birthday = new Event();
        birthday.setGuestCount(15);
        birthday.setFoodOrdered("pizza");
        birthday.setDrinksOrdered("craft beer");
        birthday.setEntertainment("none");
        birthday.setPackageCost(80);

        Event reunion = new Event();
        reunion.setGuestCount(100);
        reunion.setFoodOrdered("full catering");
        reunion.setDrinksOrdered("full bar");
        reunion.setEntertainment("band");
        reunion.setPackageCost(1750);

        ArrayList<Event> allPackages = new ArrayList<Event>();

        allPackages.add(wedding);
        allPackages.add(birthday);
        allPackages.add(reunion);

        boolean planning = true;
        while (planning){
            try {
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Welcome to the PDX Event Planner App!");
                System.out.println("Would you like to view our package deals or plan your own event? Type 'packages' or 'plan' to navigate.");
                String navigationChoice = bufferedReader.readLine().toLowerCase();
                if (navigationChoice.equals("packages")){
                    System.out.println("");
                    for (Event event : allPackages) {
                        System.out.println("-----------");
                        System.out.println(event.getFoodOrdered());
                        System.out.println(event.getDrinksOrdered());
                        System.out.println(event.getEntertainment());
                        double price = event.getPackageCost();
                        System.out.println(formatter.format(price));
                    }
                }

                Event party = new Event();
                System.out.println("");
                System.out.println("We are currently offering a seasonal discount on our event hosting. Enter the coupon code FUNEVENT2018 when prompted to receive %20 off your order.");
                System.out.println("Additionally, events with at least 150 attendees will receive a coupon for a free DJ");
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
                System.out.println("Yum! What about drinks? Which would you like of the following: Soda, Craft Beer, or Full Bar?");
                boolean choosingDrinks = true;
                while (choosingDrinks){
                    String drink = bufferedReader.readLine().toLowerCase();
                    if (drink.equals("soda") || drink.equals("craft beer") || drink.equals("full bar")){
                        party.setDrinksOrdered(drink);
                        party.setDrinkCost();
                        choosingDrinks = false;
                    } else {
                        System.out.println("I didn't recognize that entry. Please choose one of the above options.");
                    }
                }
                boolean choosingEntertainment = true;
                while (choosingEntertainment){
                    if (guests >= 150) {
                        System.out.println("You have automatically qualified for a free DJ coupon. Would you like to take advantage of this one-time offer? Y/N?");
                        boolean decidingOnOffer = true;
                        while (decidingOnOffer) {
                            String djOffer = bufferedReader.readLine().toLowerCase();
                            if (djOffer.equals("y")) {
                                party.setEntertainment("none");
                                party.setEntertainmentCost();
                                decidingOnOffer = false;
                                choosingEntertainment = false;
                            } else {
                                System.out.println("No Problem! What type of musical entertainment would you like? DJ, Band, or none?");
                                String entertainer = bufferedReader.readLine().toLowerCase();
                                if (entertainer.equals("dj") || entertainer.equals("band") || entertainer.equals("none")) {
                                    party.setEntertainment(entertainer);
                                    party.setEntertainmentCost();
                                    choosingEntertainment = false;
                                    decidingOnOffer = false;
                                } else {
                                    System.out.println("I didn't recognize that entry. Please try again.");
                                    decidingOnOffer = false;
                                }
                            }
                        }
                    } else {
                        System.out.println("Sounds good! What type of musical entertainment would you like? DJ, Band, or none?");
                        String entertainer = bufferedReader.readLine().toLowerCase();
                        if (entertainer.equals("dj") || entertainer.equals("band") || entertainer.equals("none")) {
                            party.setEntertainment(entertainer);
                            party.setEntertainmentCost();
                            choosingEntertainment = false;
                        } else {
                            System.out.println("I didn't recognize that entry. Please choose one of the above options.");
                        }
                    }
                }
                party.setEventCost();
                double eventPrice = party.getEventCost();

                System.out.println("Great! The cost of your event will be: " + formatter.format(eventPrice) + ".");
                System.out.println("Please enter a promotional coupon code if available.");
                String coupon = bufferedReader.readLine();
                if (coupon.equals("FUNEVENT2018")){
                    System.out.println("Code accepted! %20 has been subtracted from your bill.");
                    double discount = (party.getEventCost()*80)/100;

                    System.out.println("The updated cost of your event will be: " + formatter.format(discount) + ".");
                    System.out.println("We hope you enjoy your party! Goodbye!");
                    planning = false;
                } else {
                    System.out.println("No coupon found");
                    System.out.println("The cost of your event will be: " + formatter.format(eventPrice) + ".");
                    System.out.println("We hope you enjoy your party! Goodbye!");
                    planning = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
