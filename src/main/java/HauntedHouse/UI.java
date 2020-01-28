package HauntedHouse;

import java.util.List;
import java.util.Scanner;

public class UI {

    /*Greeting/back-story, other text and descriptions.
     */
    Scanner userInput = new Scanner(System.in);

    public void startGame() {
        System.out.println("Good morning! Late night? How's your head? It seems like you had fun at yesterday's Academy after-work drinks....\n" +
                "But wait. Where are you? You look around and discover that you are in a dimly-lit narrow corridor.\n" +
                "There are several doors leading off the corridor, each with a sign above the door.\n" +
                "There seems to be a kitchen, storage room, basement, laundry room, and a door marked exit.\n" +
                "You go to the door marked exit. You rattle the handle violently, but the door doesn't budge. The door has four locks.\n" +
                "You wonder where the keys might be...\n");
        printCommandList();
        whatNext();
    }

    public void whatNext() {
        boolean cont = true;
        while(cont) {
            System.out.println("\nWhat do you want to do next?");
            System.out.print("corridor > ");
            String action = userInput.nextLine().trim().toLowerCase();

            switch (action) {
                case "quit":
                    cont = false;
                    System.out.println("Awww...too scary for you? Ok, bye for now.");
                    break;
                case "help":
                    printCommandList();
                    break;
                case "go":
                    System.out.println("Where do you want to go?");
                    System.out.println("Rooms available are: kitchen or exit door. That's it. Deal with it.");
                    String whereTo = userInput.nextLine();
                    switch (whereTo) {
                        case "kitchen":
                            Kitchen kitchen = new Kitchen();
                            kitchen.introduceRoom();
                            boolean inTheKitchen = true;
// and here goes while loop in the kitchen, maybe/hope to make it a method to use in all of the rooms?!?!?
                            while (inTheKitchen) {
                                System.out.println("What do you want to do?");
                                System.out.print("kitchen > ");
                                String toDo = userInput.nextLine().trim().toLowerCase();

                                switch (toDo) {
                                    case "quit":
                                        inTheKitchen = false;
                                        System.out.println("Awww...too scary for you? Ok, bye for now.");
                                        break;
                                    case "help":
                                        printCommandList();
                                        break;
                                    case "go":
                                        System.out.println("There is nowhere you can go right now. Sad.");
                                        break;
                                    case "inventory":
                                        InventoryStuff.printInventory();
                                        break;
                                    case "take":
                                        System.out.println("What do you want to take? Please name the object.");
                                        String whatToTake = userInput.nextLine().toLowerCase().trim();
                                        if ("chopsticks".equals(whatToTake)) {
                                            if(!InventoryStuff.hasOnInventory(whatToTake)) {
                                                InventoryStuff.addToInventory(whatToTake);
                                                System.out.println("The chopsticks have been added to your inventory.");
                                            } else {
                                                System.out.println("It is already on the list. Don't try your luck my dear.");
                                            }
                                        } else {
                                            System.out.println("That is not yours to take.");
                                        }
                                        break;
                                    case "use": //uses inventorylist as a guide
                                        System.out.println("Alone are you? No one to use your items on? Use the force. Oh wait, you are not a jedi.");
                                        break;
                                    case "open":
                                        System.out.println("Things you can open here:");
                                        System.out.println(kitchen.getFurnitureYouCanOpen());
                                        break;
                                    case "open fridge":
                                        kitchen.getMonster().introduceMonster();
                                        boolean inTheFridge = true;
                                        while(inTheFridge) {
                                            System.out.println("Better think quick. What to do?");
                                            String what = userInput.nextLine().trim().toLowerCase();
                                            switch (what) {
                                                case "use":
                                                    System.out.println("Want to use some of these items:");
                                                    InventoryStuff.printInventory();
                                                    break;
                                                case "use apple":
                                                    kitchen.getMonster().makeFriendsWithHero();
                                                    inTheFridge = false;
                                                    inTheKitchen = false;
                                                    System.out.println("You are safely back in the corridor.");
                                                    break;
                                                case "use chopsticks":
                                                    kitchen.getMonster().monsterDies();
                                                    inTheFridge = false;
                                                    inTheKitchen = false;
                                                    System.out.println("You are safely back in the corridor.");
                                                    break;
                                                default:
                                                    kitchen.getMonster().killHero();
                                                    break;
                                            }
                                        }
                                        break;
                                    case "open trash can":
                                        System.out.println("You have found a shiny red apple.");
                                        InventoryStuff.addToInventory("apple");
                                        System.out.println("The apple has been added to your inventory.");
                                        break;
                                    default:
                                        System.out.println("That's not a command. Are you still drunk? Please try again.");
                                        break;
                                }
//and here ends the while loop in the kitchen
                            }
                            break;
                        case "storage room":
                            //method here
                            break;
                        case "basement":
                            //method here
                            break;
                        case "laundry room":
                            //method here
                            break;
                        case "corridor":
                            //method here
                            break;
                        case "exit":
                            if (InventoryStuff.getNumberOfKeys() == 4) {
                                System.out.println("Well done! You're free! See you next Saturday...?");
                                System.exit(0);
                            } else {
                                System.out.println("You don't have enough keys to open the door. You're trapped.");
                            }
                            break;
                        default:
                            System.out.println("That's not a command. Are you still drunk? Please try again.");
                            break;

                    }
                    break;
                case "inventory":
                    InventoryStuff.printInventory();
                    break;

                case "take":
                    System.out.println("There's nothing to take.");
                    break;

                case "use":
                    System.out.println("You don't need to use anything here.");
                    break;


                case "open":
                    System.out.println("There's nothing to open here. Go to the exit when you have enough keys.");
                    break;

                default:
                    System.out.println("That's not a command. Are you still drunk? Please try again.");
                    break;
            }
        }

    }

    public static void printCommandList () {
        System.out.println("******************************************");
        System.out.println("AVAILABLE COMMANDS ARE:\nGo\nUse\nOpen\nTake\nInventory\nHelp (to see list again)\nQuit (to end game)");
        System.out.println("******************************************");
    }
}


