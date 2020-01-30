package HauntedHouse;

public class Kitchen implements Room {

    @Override
    public void introduceRoom() {
        System.out.println("You have entered the kitchen. You are greeted by the smell of something rotting.\n" +
                "There is a fridge quietly humming in the corner, a trash can, and an oven. Someone has left a pair of chopsticks lying around.\n" +
                "You wonder where those keys could be...\n");
    }

}