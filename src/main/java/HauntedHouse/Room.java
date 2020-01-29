package HauntedHouse;

import HauntedHouse.UI;
import HauntedHouse.InventoryStuff;

import java.util.List;
import java.util.Scanner;


public abstract class Room {
    /* Each room has their own monster and their own objects, and a hidden key. Room objects contain their description?
    Should this be an abstract class/interface?
     */

    abstract void introduceRoom();

    abstract List<String> getFurnitureYouCanOpen();

    abstract List<String> getStuffYouCanTake();
    
    abstract Monster getMonster();


/*    public void actionsInTheRoom() {
        Scanner userInput = new Scanner(System.in);

        boolean cont = true;
        while (cont) {
            System.out.println("\nWhat do you want to do next?");
            System.out.print(">");
            String action = userInput.nextLine().trim().toLowerCase();

            switch (action) {
                case "quit":
                    cont = false;
                    System.out.println("Awww...too scary for you? Ok, bye for now.");
                    break;

                case "help":
                    UI.printCommandList();
                    break;

                case "go":
                    System.out.println("Where do you want to go?");
                    String whereTo = userInput.nextLine();
                    switch (whereTo) {
                        case "corridor":
                            //method here
                            break;

                        default:
                            System.out.println("You can't go there right now. Back to the corridor?");
                            break;

                    }
                case "inventory":
                    InventoryStuff.printInventory();
                    break;

                case "take":
                    //method here
                    System.out.println("What do you want to take?");
                    String whatToTake = userInput.nextLine().toLowerCase().trim();
                    switch (whatToTake) {
                        case "apple":
                            //method here
                            break;
                        case "use":
                            //method here
                            break;
                        case "look":
                            //method here
                            break;
                        case "open":
                            //method here
                            break;
                        default:
                            System.out.println("That's not a command. Are you still drunk? Please try again.");
                            break;

                    }
                    default:
                    System.out.println("That's not a command. Are you still drunk? Please try again.");
                    break;*/
            }

