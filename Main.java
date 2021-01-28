//vendingmachine class begins
import java.util.Random;
class VendingMachine {
    //instance variables
    private String productName;
    private double price;
    private final int maxQuantity = 50;  //maximum quantity of 50 for each item/object
    private int currentStock;

    //vending machine constructor with the 3 required instance variables (product name, price, and stock)
    public VendingMachine(String productName, double price, int currentStock) {
        this.productName = productName;
        this.price = price;
        this.currentStock = currentStock;
    }

    //vending machine constructor with no arguments
    public VendingMachine() {
    }

    //get price method which tells the current price of object
    public double getPrice() {

        return price;
    }

    //allows to override the price of an object to a price of your choice
    public void setPrice(double price) {

        this.price = price;
    }

    //lets you know how much stock of the object is available
    public int getCurrentStock() {
        if (currentStock < maxQuantity) {
            return currentStock;
        } else {
            return maxQuantity;
        }
    }
//this gives the profit amount(sales of item)
public double checkTotalSales() {
    if (currentStock < maxQuantity) {
        return price * (maxQuantity - currentStock); //maxquantity(always 50) - currentstock results in the number of the specific product sold
    } else {
        return price * maxQuantity;
    }
}
public void purchase() {
    currentStock -= 1;

    if (currentStock < 0) {
        System.out.println("Item is sold out");
    }
    else {
        System.out.println("Purchase Complete");
        System.out.println("Available Stock: " + getCurrentStock());
    }
    System.out.println("Item Cost: " + getPrice());
    System.out.println(" ");
}
public boolean checkStock() {
    if (currentStock >= 0) {
        return true;
    }
    else {
        return false;
    }
}
}

//class to run methods as well as declaring new objects
public class Main {
public static void main (String[] args) {
    //5 objects which are being sold by the vending machine
    VendingMachine softDrinks = new VendingMachine("softdrinks", 1.99, 2); //in brakcets is the name of the item followed by the price and then the stock of the item inside the vending machine
    VendingMachine chips = new VendingMachine("chips", 3.99, 3);
    VendingMachine chocolate = new VendingMachine("chocolate", 1.50, 25);
    VendingMachine granolaBars = new VendingMachine("granolaBar", 2.50, 15);
    VendingMachine fruits = new VendingMachine("fruits", 2.99, 56);

//declaring a variable count for each item to keep track of how many times it is chosen in the random for loop
    int SDCount = 0;
    int ChipCount = 0;
    int ChocCount = 0;
    int GBCount = 0;
    int FruitCount = 0;

    //Random number for loop which creates 20 random numbers between 0 & 4
    Random randNum = new Random();
    for (int i = 0; i < 20; i++) {
        int randomNumber = randNum.nextInt(5);
        if (randomNumber == 0){
            System.out.println("Attempting to purchase soft drinks...");
            softDrinks.purchase();
            if (softDrinks.checkStock()) {
                SDCount++;
            }
        }
        else if (randomNumber == 1){
            System.out.println("Attempting to purchase chips...");
            chips.purchase();
            if (chips.checkStock()) {
                ChipCount++;
            }
        }
        else if (randomNumber == 2){
            System.out.println("Attempting to purchase chocolate...");
            chocolate.purchase();
            if (chocolate.checkStock()) {
                ChocCount++;
            }
        }
        else if (randomNumber == 3){
            System.out.println("Attempting to purchase granola bars...");
            granolaBars.purchase();
            if (granolaBars.checkStock()){
                GBCount++;
            }
        }
        else if (randomNumber == 4){
            System.out.println("Attempting to purchase fruits...");
            fruits.purchase();
            if (fruits.checkStock()) {
                FruitCount++;
            }
        }
    }
    //total price for each item (total bill)
    double SdTotal = SDCount * softDrinks.getPrice();
    double ChipTotal = ChipCount * chips.getPrice();
    double ChocTotal = ChocCount * chocolate.getPrice();
    double GbTotal = GBCount * granolaBars.getPrice();
    double FruitTotal = FruitCount * fruits.getPrice();
//printing the totals
    System.out.println("Total soft drinks purchased: " + SDCount + " || Total price = " + SdTotal);
    System.out.println("total chips purchased:  " + ChipCount + " || Total price = " + ChipTotal);
    System.out.println("Total chocolate purchased: " + ChocCount + " || Total price = " + ChocTotal);
    System.out.println("Total granola bars purchased: " + GBCount + " || Total price = " + GbTotal);
    System.out.println("Total fruits purchased: " + FruitCount + " || Total price = " + FruitTotal);
//printing the grand total of all the items
    double grandTotal = SdTotal + ChipTotal + ChocTotal + GbTotal + FruitTotal;
    System.out.println("Total Bill = " + grandTotal);
}
}