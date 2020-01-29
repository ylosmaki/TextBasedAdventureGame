package HauntedHouse;

import java.util.List;

public class StorageRoom extends Room {

    @Override
    public void introduceRoom() {
        System.out.println("You trip over a box and fall into a cluttered storage room.\n" +
                "A broken flashlight and a wooden baseball bat lie abandoned in the corner next to a dusty old suitcase.\n" +
                "There seem to be some papers sticking out of the corner of the suitcase. A pile of boxes has been lazily stacked in another corner.\n" +
                "Well, those keys aren't going to find themselves...");
    }
}
