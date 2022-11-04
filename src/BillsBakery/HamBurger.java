package BillsBakery;

public class HamBurger {

    private final String RollType;
    private final String Meat;
    private int Price;
    private static int count = 0;

    private final boolean Lettuce;
    private final boolean Tomato;
    private final boolean Carrot;
    private final boolean Cheese;

    public HamBurger(String rollType, String meat, int price, boolean lettuce, boolean tomato, boolean carrot, boolean cheese) {
        RollType = rollType;
        Meat = meat;
        Price = price;
        Lettuce = lettuce;
        Tomato = tomato;
        Carrot = carrot;
        Cheese = cheese;
    }

    public int getTotalPrice() {
        int lettucePrice = Lettuce ? 15 : 0;
        int tomatoPrice = Tomato ? 10 : 0;
        int carrotPrice = Carrot ? 15 : 0;
        int cheesePrice = Cheese ? 25 : 0;
        Price = Price + lettucePrice + tomatoPrice + carrotPrice + cheesePrice;
        return Price;
    }

    public String getItemDetails() {
        count++;
        String ItemDetails;

        if (Lettuce || Tomato || Carrot || Cheese) {
            ItemDetails = "\nExtras: ";
            if (Lettuce)
                ItemDetails += "Lettuce ";
            if (Tomato)
                ItemDetails += "Tomato ";
            if (Carrot)
                ItemDetails += "Carrot ";
            if (Cheese)
                ItemDetails += "Cheese ";
        } else {
            ItemDetails = "(No Extras added)";
        }

        ItemDetails += String.format("\nRoll Type:%s, Meat:%s, Price:%d \n\n", RollType, Meat, Price);
        return ItemDetails;
    }
}
