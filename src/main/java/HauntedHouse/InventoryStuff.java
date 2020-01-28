package HauntedHouse;

import java.util.ArrayList;
import java.util.List;

public class InventoryStuff {
    /* List maintenance. Things happen here when the hero performs actions like take, use etc.
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
        inventory.add(thing);
    }

    public static void removeFromInventory(String thing) {
        inventory.remove(thing);
    }

    public static void printInventory() {
        System.out.println("You have: " + String.join(", ",inventory) + " and " + numberOfKeys + " keys.");
    }

    public String toString() { return "You have: " + String.join(", ",inventory) + " and " + numberOfKeys + " keys."; }
}
