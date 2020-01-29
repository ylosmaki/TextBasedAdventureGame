package HauntedHouse;

import java.util.List;

public class Basement extends Room {


    @Override
    public void introduceRoom() {
        System.out.println("You walk down a steep staircase into a cold damp basement. Random objects litter the room.\n" +
                "Someone appears to have been working on something down here, and they've left a chainsaw, a hammer and an oil can behind.\n" +                "                \"A telephone lies in the middle of the floor, and you hear a rattling noise coming from a musty old trunk.\\n\" +\n" +
                "But there's no sign of any keys....");
    }
}
