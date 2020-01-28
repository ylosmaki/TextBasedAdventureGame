import java.util.ArrayList;
import java.util.List;

public class InventoryStuff {
    /* List maintenance. Things happen here when the hero performs actions like take, use etc.
     */
    private List<String> inventory;
    private int numberOfKeys;

    public InventoryStuff() {
        this.inventory = new ArrayList<>();
        this.numberOfKeys = 0;
 /*       addToInventory("Detergent"); //testi
        addToInventory("Apple");   ///testi*/
    }

    public int getNumberOfKeys() {
        return numberOfKeys;
    }

    public void setNumberOfKeys(int numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }
    public void addKey() {
        this.numberOfKeys++;
    }

    public void addToInventory(String thing) {
        this.inventory.add(thing);
    }

    public void removeFromInventory(String thing) {
        this.inventory.remove(thing);
    }

    public List<String> getInventory() {
        return this.inventory;
    }

    @Override
    public String toString() {
        return "You have: " + String.join(", ",inventory) + " and " + numberOfKeys + " keys.";
    }
}
