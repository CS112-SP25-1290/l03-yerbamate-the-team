import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create an array that can store Tea and YerbaMate (both are CaffeinatedBeverage)
        CaffeinatedBeverage[] inventory = new CaffeinatedBeverage[10];
        Scanner keyboard = new Scanner(System.in);
        
        int choice, ounces = 0, brewTemp = 0, count = 0;
        String name;
        double price = 0.0;
        
        do {
            System.out.println("\nChoose an option:");
            System.out.println("1) Enter new Tea");
            System.out.println("2) Enter new Yerba Mate");
            System.out.println("3) Exit");
            System.out.print(">> ");
            choice = keyboard.nextInt();
            keyboard.nextLine(); // consume newline
            
            if (choice == 1 || choice == 2) {
                // Prompt for the common data
                System.out.print("Enter name: ");
                name = keyboard.nextLine();
                System.out.print("Enter ounces: ");
                ounces = keyboard.nextInt();
                System.out.print("Enter price: $");
                price = keyboard.nextDouble();
                keyboard.nextLine(); // consume newline
                System.out.print("Enter brew temperature (in Celsius): ");
                brewTemp = keyboard.nextInt();
                keyboard.nextLine(); // consume newline
                
                if (choice == 1) {
                    // Create a Tea object
                    inventory[count] = new Tea(name, ounces, price, brewTemp);
                    count++;
                } else {
                    // OCreate a YerbaMate object
                    // Pass 0 for numPasses since they just purchased the drink.
                    inventory[count] = new YerbaMate(name, ounces, price, brewTemp, 0);
                    count++;
                }
            } else if (choice == 3) {
                //  Exit and display inventory information
                System.out.println("\nALL BEVERAGES:");
                printDrinks(inventory, count);
                
                double avgPrice = findAveragePrice(inventory, count);
                System.out.println("\nAverage Price: $" + avgPrice);
                
                YerbaMate highest = findHighestPricedYerbaMate(inventory, count);
                if (highest != null) {
                    System.out.println("Highest Priced YerbaMate: " + highest);
                } else {
                    System.out.println("No YerbaMate found in inventory.");
                }
            } else {
                System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        } while (choice != 3);
        
        keyboard.close();
    }
    
    //  Method to compute the average price of all beverages in the inventory.
    public static double findAveragePrice(CaffeinatedBeverage[] inventory, int count) {
        if (count == 0) return 0.0;
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += inventory[i].getPrice();
        }
        return total / count;
    }
    
    // Method to find the highest priced YerbaMate beverage.
    public static YerbaMate findHighestPricedYerbaMate(CaffeinatedBeverage[] inventory, int count) {
        YerbaMate highest = null;
        for (int i = 0; i < count; i++) {
            if (inventory[i] instanceof YerbaMate) {
                YerbaMate current = (YerbaMate) inventory[i];
                if (highest == null || current.getPrice() > highest.getPrice()) {
                    highest = current;
                }
            }
        }
        return highest;
    }
    
    // Method to print all beverages in the inventory.
    public static void printDrinks(CaffeinatedBeverage[] inventory, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(inventory[i]);
        }
    }
}
