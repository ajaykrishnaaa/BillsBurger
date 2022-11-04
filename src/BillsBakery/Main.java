package BillsBakery;

import java.util.Scanner;

public class Main {

    private static boolean Lettuce;
    private static boolean Tomato;
    private static boolean Carrot;
    private static boolean Cheese;
    private static String RollType = "";
    private static String Meat = "";
    private static int Price = 0;
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean AddItem;
    private static boolean Checkout = false;
    private static int FinalPrice = 0;
    private static int Count = 0;
    private static String ItemDetails = "";

    public static void main(String[] args) {
        System.out.println("Hi Welcome to Bill's Burgers..\n");
        DisplayMenu();
    }

    public static void DisplayMenu() {
        Lettuce = Tomato = Carrot = Cheese = false;
        System.out.println("Here's our Menu,\n" +
                "  1.Chicken Basic Burger: ₹50 \n" +
                "  2.Mutton Basic Burger: ₹70 \n" +
                "  3.Chicken Tikka Burger: ₹70 \n" +
                "  4.Mutton Tikka Burger: ₹90 \n\n" +
                "Our Special: \n" +
                "  5.Healthy Burger: ₹100 \n" +
                "  6.Deluxe Burger: ₹150 ");
        System.out.println("Please enter your choice");
        AddBurgersToCart();
    }

    public static void DisplayExtras() {
        System.out.println("Would you like to add extras?");
        System.out.println("Extras: \n " +
                "   1.Lettuce: ₹15 \n " +
                "   2.Tomato: ₹10 \n " +
                "   3.Carrot: ₹15 \n " +
                "   4.Cheese: ₹25");
        System.out.println("Please enter your choice");
        System.out.println("Please enter 0 to add to cart");
        System.out.println("Please enter 9 to Checkout");
        AddExtras();
    }

    public static void AddBurgersToCart() {
        try {
            Count++;
            ItemDetails += (Count + ".Variation:");
            do {
                int userChoice = scanner.nextInt();
                AddItem = false;
                switch (userChoice) {
                    case 1:
                        Meat = "Chicken";
                        RollType = "Basic";
                        Price = 50;
                        ItemDetails += "Chicken Basic Burger";
                        DisplayExtras();
                        break;
                    case 2:
                        Meat = "Mutton";
                        RollType = "Basic";
                        Price = 70;
                        ItemDetails += "Mutton Basic Burger";
                        DisplayExtras();
                        break;
                    case 3:
                        Meat = "Chicken";
                        RollType = "Tikka";
                        Price = 70;
                        ItemDetails += ":Chicken Tikka Burger";
                        DisplayExtras();
                        break;
                    case 4:
                        Meat = "Mutton";
                        RollType = "Tikka";
                        Price = 90;
                        ItemDetails += ":Mutton Tikka Burger";
                        DisplayExtras();
                        break;
                    case 5:
                        Meat = "";
                        RollType = "Healthy";
                        Price = 100;
                        ItemDetails += ":Healthy Burger";
                        DisplayExtras();
                        break;
                    case 6:
                        Meat = "";
                        RollType = "Deluxe";
                        Price = 100;
                        ItemDetails += ":Deluxe Burger";
                        DisplayExtras();
                        break;
                    default:
                        System.out.println("Please enter valid input");
                        AddItem = true;
                        DisplayMenu();
                }

            }
            while (AddItem);
        } catch (Exception ex) {
            System.out.println("Exception:" + ex);
            System.out.println("Please enter valid input");
        }
    }

    public static void AddExtras() {
        try {
            do {
                AddItem = true;
                if (Lettuce && Tomato && Carrot && Cheese) {
                    Checkout();
                    break;
                }
                int userChoice = scanner.nextInt();
                switch (userChoice) {
                    case 0:
                        AddItem = false;
                        Checkout();
                        break;
                    case 1:
                        Lettuce = true;
                        break;
                    case 2:
                        Tomato = true;
                        break;
                    case 3:
                        Carrot = true;
                        break;
                    case 4:
                        Cheese = true;
                        break;
                    case 9:
                        Checkout = true;
                        AddItem = false;
                        Checkout();
                        break;
                    default:
                        System.out.println("Please enter valid input");
                        DisplayExtras();
                }
            }
            while (AddItem);
        } catch (Exception ex) {
            System.out.println("Exception:" + ex.getMessage());
            System.out.println("Please enter valid input");
        }
    }

    public static void Checkout() {
        HamBurger hamBurger = new HamBurger(RollType, Meat, Price, Lettuce, Tomato, Carrot, Cheese);
        FinalPrice = FinalPrice + hamBurger.getTotalPrice();
        ItemDetails += hamBurger.getItemDetails();

        if (!Checkout) {
            DisplayMenu();
            Checkout = false;
        } else {
            System.out.println("\n*************************************************************************");
            System.out.println(ItemDetails);
            System.out.println("Final Price:" + FinalPrice);
            System.out.println("*************************************************************************\n");
        }
    }
}
