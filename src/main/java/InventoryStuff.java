import java.util.ArrayList;
import java.util.List;

public class InventoryStuff {
    /* List maintenance. Things happen here when the hero performs actions like take, use etc.
     */
    private List<String> inventory;

    public InventoryStuff() {
        this.inventory = new ArrayList<>();
    }

    public void addToInventory(String thing) {
        this.inventory.add(thing);
    }

    public void removeFromInventory(String thing) {
        this.inventory.remove(thing);
    }

    @Override
    public String toString() {
        return "You have: " + inventory;
    }
}
