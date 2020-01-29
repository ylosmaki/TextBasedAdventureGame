package Inventory;

import java.util.ArrayList;
import java.util.List;

public class InventoryStuff {
    /* List maintenance. Changes happen to the inventory through these methods when the player performs actions like take, use etc.
     */
    private static List<String> inventory = new ArrayList<>();
    private static int numberOfKeys = 0;

    public static int getNumberOfKeys() {
        return numberOfKeys;
    }

    public static void addKey() {
        numberOfKeys++;
    }

    public static void addToInventory(String thing) {
        if (inventory.contains(thing)) {
            System.out.println("You already have that in your inventory. Don't be greedy.");
        } else  {
            inventory.add(thing);
            System.out.println("");
            System.out.println(thing + " has been added to your inventory.");
        }
    }

    public static void removeFromInventory(String thing) {
        inventory.remove(thing);
    }

    public static void printInventory() {
        if (inventory.isEmpty()) {
            System.out.println("You have nothing in your inventory and " + numberOfKeys + " keys.");
        }
        System.out.println("You have: " + String.join(", ",inventory) + " and " + numberOfKeys + " keys.");
    }

}
