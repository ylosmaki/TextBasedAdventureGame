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
                    String whereTo = userInput.nextLine().trim().toLowerCase();
                    switch (whereTo) {
                        case "kitchen":
                            Room kitchen = new Kitchen();
                            kitchen.introduceRoom();
                            boolean inTheKitchen = true;
//this section works as it is ->
                            while (inTheKitchen) {
                                System.out.println("What do you want to do?");
                                System.out.print("kitchen > ");
                                String toDo = userInput.nextLine().trim().toLowerCase();
// and here goes while loop in the kitchen, maybe/hope to make it a method to use in all of the rooms?!?!
                                roomLoop(toDo, kitchen);

//and here ends the while loop in the kitchen*/
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

//a method used for handling the actions inside the rooms. Uses rooms own furniture and stuff -lists
    public void roomLoop(String toDo, Room room) {

            switch (toDo) {
                case "quit":
                    System.out.println("Awww...too scary for you? Ok, bye for now.");
                    System.exit(0);
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
                    if (room.getStuffYouCanTake().contains(whatToTake)) {
                        if (!InventoryStuff.isInInventory(whatToTake)) {
                            InventoryStuff.addToInventory(whatToTake);
                            System.out.println("It has been added to your inventory.");
                        } else {
                            System.out.println("It is already on the list. Don't try your luck my dear.");
                        }
                    } else {
                        System.out.println("That is not yours to take.");
                    }
                    break;
                
                    
                case "open":
                    System.out.println("Things you can open here:");
                    System.out.println(room.getFurnitureYouCanOpen());
                    System.out.println("What do you want to open?");
                    String whatToOpen = userInput.nextLine().toLowerCase().trim();
                    if(room.getFurnitureYouCanOpen().contains(whatToOpen)) {
                        if("trash can".equals(whatToOpen)) {
                            System.out.println("You have found a shiny red apple.");
                            InventoryStuff.addToInventory("apple");
                            System.out.println("The apple has been added to your inventory.");
                        } else {
                            room.getMonster().introduceMonster();
                            boolean inTheFridge = true;
                            while (inTheFridge) {
                                System.out.println("Better think quick. What to do?");
                                String what = userInput.nextLine().trim().toLowerCase();
                                switch (what) {
                                    case "use": //uses inventorylist as a guide
                                        System.out.println("Want to use some of these items:");
                                        InventoryStuff.printInventory();
                                        System.out.println("What do you want to use?");
                                        String whatToUse = userInput.nextLine().trim().toLowerCase();

                                        if(InventoryStuff.isInInventory(whatToUse)) {
                                            switch(whatToUse) {
                                                case "apple":
                                                    room.getMonster().makeFriendsWithHero();
                                                    inTheFridge = false;
//                                                    inTheKitchen = false;

                                                    System.out.println("You are safely back in the corridor.");
                                                    whatNext();
                                                break;
                                                case "chopsticks":
                                                    room.getMonster().monsterDies();
                                                    inTheFridge = false;
//                                                    inTheKitchen = false;
                                                    System.out.println("You are safely back in the corridor.");
                                                    whatNext();
                                                    break;
                                                default:
                                                    System.out.println("You can't use that.");
                                            }
                                        } else {
                                            System.out.println("There is no such thing to use.");
                                        }
                                        break;
                                    default:
                                        room.getMonster().killHero();
                                        break;
                                }
                            }

                        }
                    } else {
                        System.out.println("You can't open that.");
                    }
                    break;
                default:
                    System.out.println("That's not a command. Are you still drunk? Please try again.");
                    break;
            }


    }
///here end the method for actions in the rooms
        
    public static void printCommandList () {
        System.out.println("******************************************");
        System.out.println("AVAILABLE COMMANDS ARE:\nGo\nUse\nOpen\nTake\nInventory\nHelp (to see list again)\nQuit (to end game)");
        System.out.println("******************************************");
    }
}


