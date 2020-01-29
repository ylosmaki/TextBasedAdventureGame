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
            System.out.print("corridor> ");
            String action = userInput.nextLine().trim().toLowerCase();

            switch (action) {
                case "quit":
                    System.out.println("Awww...too scary for you? Ok, bye for now.");
                    System.exit(0);
                    break;
                case "help":
                    printCommandList();
                    break;
                case "go":
                    System.out.println("Where do you want to go?");
                    System.out.println("Available rooms: kitchen, basement, laundry room, storage room, exit.");
                    System.out.print("corridor> ");
                    String whereTo = userInput.nextLine().trim().toLowerCase();
                    switch (whereTo) {
                        case "kitchen":
                            Room kitchen = new Kitchen();
                            kitchen.introduceRoom();
                            boolean inTheKitchen = true;
//this section works as it is ->
                            while (inTheKitchen) {
                                System.out.println("What do you want to do?");
                                System.out.print("kitchen> ");
                                String toDo = userInput.nextLine().trim().toLowerCase();
// and here goes while loop in the kitchen, maybe/hope to make it a method to use in all of the rooms?!?!
                                kitchenLoop(toDo);

//and here ends the while loop in the kitchen*/
                            }
                            break;

                        case "storage room":
                            Room storageRoom = new StorageRoom();
                            storageRoom.introduceRoom();
                            boolean inTheStorageRoom = true;
                            while (inTheStorageRoom) {
                                System.out.println("What do you want to do?");
                                System.out.print("storage room> ");
                                String toDo = userInput.nextLine().trim().toLowerCase();
                                storageRoomLoop(toDo);
                            }
                            break;

                        case "basement":
                            Room basement = new Basement();
                            basement.introduceRoom();
                            boolean inTheBasement = true;
                            while (inTheBasement) {
                                System.out.println("What do you want to do?");
                                System.out.print("basement> ");
                                String toDo = userInput.nextLine().trim().toLowerCase();
                                basementLoop(toDo);
                            }
                            break;

                        case "laundry room":
                            Room laundryRoom = new LaundryRoom();
                            laundryRoom.introduceRoom();
                            boolean inTheLaundryRoom = true;
                            while (inTheLaundryRoom) {
                                System.out.println("What do you want to do?");
                                System.out.print("laundry room> ");
                                String toDo = userInput.nextLine().trim().toLowerCase();
                                laundryRoomLoop(toDo);
                            }
                            break;
                            //method here

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
                            System.out.println("You can't go there.");
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
                    System.out.println("There's nothing to open here.");
                    break;

                default:
                    System.out.println("That's not a command. Are you still drunk? Please try again.");
                    break;
            }
        }

    }

//a method used for handling the actions inside the rooms. Uses rooms own furniture and stuff -lists
    public void kitchenLoop(String toDo) {
        Monster vamp = new Vampire();

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
                case "open fridge":
                    vamp.introduceMonster();
                    fightTheVampire();
                    break;
                case "open trash can":
                    System.out.println("You rifle through the trash can.\n" +
                            "Underneath everything you find a shiny red apple. You pick it up.");
                    InventoryStuff.addToInventory("apple");
                    break;
                case "open oven":
                    System.out.println("Peering into the oven, you find a delicious-looking warm roast chicken. Hangover food! Yay!\n" +
                            "You take it out of the oven.");
                    InventoryStuff.addToInventory("roast chicken");
                    break;

                case "take":
                    System.out.println("Take what?");
                    System.out.print(">");
                    String takeWhat = userInput.nextLine().toLowerCase().trim();
                    switch (takeWhat) {
                        case "quit":
                            System.out.println("Awww...too scary for you? Ok, bye for now.");
                            System.exit(0);
                            break;
                        case "help":
                            printCommandList();
                            break;
                        case "inventory":
                            InventoryStuff.printInventory();
                            break;
                        case "chopsticks":
                            InventoryStuff.addToInventory("chopsticks");
                            break;
                        default:
                            System.out.println("Nope, try again.");
                            break;
                    }
                
                    break;
                case "take chopsticks":
                    InventoryStuff.addToInventory("chopsticks");
                    break;
                case "open":
                    System.out.println("What do you want to open?");
                    System.out.print(">");
                    String whatToOpen = userInput.nextLine().toLowerCase().trim();
                    switch (whatToOpen) {
                        case "quit":
                            System.out.println("Awww...too scary for you? Ok, bye for now.");
                            System.exit(0);
                            break;
                        case "help":
                            printCommandList();
                            break;
                        case "inventory":
                            InventoryStuff.printInventory();
                            break;
                        case "fridge":
                            vamp.introduceMonster();
                            fightTheVampire();
                            break;
                        case "trash can":
                            System.out.println("You rifle through the trash can. \n" +
                                    "Underneath everything you find a shiny red apple. You pick it up.");
                            InventoryStuff.addToInventory("apple");
                            break;
                        case "oven":
                            System.out.println("Peering into the oven, you find a delicious-looking warm roast chicken. Hangover food! Yay!\n" +
                                    "You take it out of the oven.");
                            InventoryStuff.addToInventory("roast chicken");
                            break;

                        default:
                            System.out.println("What are you doing? You can't do that. Try something else.");
                            break;
                    }
                    break;
                default:
                    System.out.println("That's not a command. Are you still drunk? Please try again.");
                    break;
            }


    }

    public void fightTheVampire() {
        Monster vamp = new Vampire();
        Scanner userInput = new Scanner(System.in);
        System.out.print(">");
        String whatToUse = userInput.nextLine();

        switch (whatToUse) {
            case "quit":
                System.out.println("Awww...too scary for you? Ok, bye for now.");
                System.exit(0);
                break;
            case "help":
                printCommandList();
                break;
            case "inventory":
                InventoryStuff.printInventory();
                break;
            case "use apple":
                vamp.makeFriendsWithHero();
                InventoryStuff.removeFromInventory("apple");
                whatNext();
                break;
            case "use chopsticks":
                vamp.monsterDies();
                InventoryStuff.removeFromInventory("chopsticks");
                whatNext();
                break;
            case "use roast chicken":
                vamp.killHero();
                System.exit(0);
                break;
            case "use":
                System.out.println("What do you want to use?");
                System.out.print(">");
                String useWhat = userInput.nextLine();
                switch (useWhat) {
                    case "apple":
                        vamp.makeFriendsWithHero();
                        InventoryStuff.removeFromInventory("apple");
                        whatNext();
                        break;
                    case "chopsticks":
                        vamp.monsterDies();
                        InventoryStuff.removeFromInventory("chopsticks");
                        whatNext();
                        break;
                    case "roast chicken":
                        vamp.killHero();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("I'm afraid that's not possible. Try something you can actually do.");
                        break;
                }
            default:
                System.out.println("Oh no, not that. Try something that makes more sense.");
                break;
        }
    }

    public void storageRoomLoop(String toDo) {
        Monster zombie = new Zombie();

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
            case "open boxes":
                zombie.introduceMonster();
                fightTheZombie();
                break;
            case "open suitcase":
                System.out.println("You throw open the dusty old suitcase to reveal a book of dad jokes and\n" +
                        "a book of sudoku puzzles. You scoop them up.");
                InventoryStuff.addToInventory("sudoku book");
                InventoryStuff.addToInventory("dad jokes book");
                break;

            case "take":
                System.out.println("Take what?");
                System.out.print(">");
                String takeWhat = userInput.nextLine().toLowerCase().trim();
                switch (takeWhat) {
                    case "quit":
                        System.out.println("Awww...too scary for you? Ok, bye for now.");
                        System.exit(0);
                        break;
                    case "help":
                        printCommandList();
                        break;
                    case "inventory":
                        InventoryStuff.printInventory();
                        break;
                    case "flashlight":
                        InventoryStuff.addToInventory("flashlight");
                        break;
                    case "baseball bat":
                        InventoryStuff.addToInventory("baseball bat");
                        break;
                    default:
                        System.out.println("Nope, try again.");
                        break;
                }

                break;
            case "take baseball bat":
                InventoryStuff.addToInventory("baseball bat");
                break;
            case "take flashlight":
                InventoryStuff.addToInventory("flashlight");
                break;

            case "open":
                System.out.println("What do you want to open?");
                System.out.print(">");
                String whatToOpen = userInput.nextLine().toLowerCase().trim();
                switch (whatToOpen) {
                    case "quit":
                        System.out.println("Awww...too scary for you? Ok, bye for now.");
                        System.exit(0);
                        break;
                    case "help":
                        printCommandList();
                        break;
                    case "inventory":
                        InventoryStuff.printInventory();
                        break;
                    case "boxes":
                        zombie.introduceMonster();
                        fightTheZombie();
                        break;
                    case "suitcase":
                        System.out.println("You throw open the dusty old suitcase to reveal a book of dad jokes and\n" +
                                "a book of sudoku puzzles. You scoop them up.");
                        InventoryStuff.addToInventory("sudoku book");
                        InventoryStuff.addToInventory("dad jokes book");
                        break;
                    default:
                        System.out.println("What are you doing? You can't do that. Try something else.");
                        break;
                }
                break;
            default:
                System.out.println("That's not a command. Are you still drunk? Please try again.");
                break;
        }

    }

    public void fightTheZombie() {
        Monster zombie = new Zombie();
        Scanner userInput = new Scanner(System.in);
        System.out.print(">");
        String whatToUse = userInput.nextLine();

        switch (whatToUse) {
            case "quit":
                System.out.println("Awww...too scary for you? Ok, bye for now.");
                System.exit(0);
                break;
            case "help":
                printCommandList();
                break;
            case "inventory":
                InventoryStuff.printInventory();
                break;
            case "use sudoku book":
                zombie.makeFriendsWithHero();
                InventoryStuff.removeFromInventory("sudoku book");
                whatNext();
                break;
            case "use dad jokes book":
                zombie.monsterDies();
                InventoryStuff.removeFromInventory("dad jokes book");
                whatNext();
                break;
            case "use baseball bat":
                zombie.killHero();
                System.exit(0);
                break;
            case "use flashlight":
                zombie.killHero();
                System.exit(0);
                break;
            case "use":
                System.out.println("What do you want to use?");
                System.out.print(">");
                String useWhat = userInput.nextLine();
                switch (useWhat) {
                    case "sudoku book":
                        zombie.makeFriendsWithHero();
                        InventoryStuff.removeFromInventory("sudoku book");
                        whatNext();
                        break;
                    case "dad jokes book":
                        zombie.monsterDies();
                        InventoryStuff.removeFromInventory("dad jokes book");
                        whatNext();
                        break;
                    case "baseball bat":
                        zombie.killHero();
                        System.exit(0);
                        break;
                    case "flashlight":
                        zombie.killHero();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("I'm afraid that's not possible. Try something you can actually do.");
                        break;
                }
            default:
                System.out.println("Oh no, not that. Try something that makes more sense.");
                break;
        }
    }

    public void laundryRoomLoop(String toDo) {
        Monster mummy = new Mummy();
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
            case "open drier":
                mummy.introduceMonster();
                fightTheMummy();
                break;
            case "open cabinet":
                System.out.println("You open the cabinet and see a brush and a bleach sitting on the shelf.\n" +
                        "You pick them up.");
                InventoryStuff.addToInventory("bleach");
                InventoryStuff.addToInventory("brush");
                break;
            case "take":
                System.out.println("Take what?");
                System.out.print(">");
                String takeWhat = userInput.nextLine().toLowerCase().trim();
                switch (takeWhat) {
                    case "quit":
                        System.out.println("Awww...too scary for you? Ok, bye for now.");
                        System.exit(0);
                        break;
                    case "help":
                        printCommandList();
                        break;
                    case "inventory":
                        InventoryStuff.printInventory();
                        break;
                    case "scissors":
                        InventoryStuff.addToInventory("scissors");
                        break;
                    default:
                        System.out.println("Nope, try again.");
                        break;
                }
                break;
            case "take scissors":
                InventoryStuff.addToInventory("scissors");
                break;
            case "open":
                System.out.println("What do you want to open?");
                System.out.print(">");
                String whatToOpen = userInput.nextLine().toLowerCase().trim();
                switch (whatToOpen) {
                    case "quit":
                        System.out.println("Awww...too scary for you? Ok, bye for now.");
                        System.exit(0);
                        break;
                    case "help":
                        printCommandList();
                        break;
                    case "inventory":
                        InventoryStuff.printInventory();
                        break;
                    case "drier":
                        mummy.introduceMonster();
                        fightTheMummy();
                        break;
                    case "cabinet":
                        System.out.println("You open the cabinet and see a brush and a bleach sitting on the shelf.\n" +
                                "You pick them up.");
                        InventoryStuff.addToInventory("bleach");
                        InventoryStuff.addToInventory("brush");
                        break;
                    default:
                        System.out.println("What are you doing? You can't do that. Try something else.");
                        break;
                }
                break;
            default:
                System.out.println("That's not a command. Are you still drunk? Please try again.");
                break;
        }
    }
    public void fightTheMummy() {
        Monster mummy = new Mummy();
        Scanner userInput = new Scanner(System.in);
        System.out.print(">");
        String whatToUse = userInput.nextLine();
        switch (whatToUse) {
            case "quit":
                System.out.println("Awww...too scary for you? Ok, bye for now.");
                System.exit(0);
                break;
            case "help":
                printCommandList();
                break;
            case "inventory":
                InventoryStuff.printInventory();
                break;
            case "use bleach":
                mummy.makeFriendsWithHero();
                InventoryStuff.removeFromInventory("bleach");
                whatNext();
                break;
            case "use scissors":
                mummy.monsterDies();
                InventoryStuff.removeFromInventory("scissors");
                whatNext();
                break;
            case "use brush":
                mummy.killHero();
                System.exit(0);
                break;
            case "use":
                System.out.println("What do you want to use?");
                System.out.print(">");
                String useWhat = userInput.nextLine();
                switch (useWhat) {
                    case "bleach":
                        mummy.makeFriendsWithHero();
                        InventoryStuff.removeFromInventory("bleach");
                        whatNext();
                        break;
                    case "scissors":
                        mummy.monsterDies();
                        InventoryStuff.removeFromInventory("scissors");
                        whatNext();
                        break;
                    case "brush":
                        mummy.killHero();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("I'm afraid that's not possible. Try something you can actually do.");
                        break;
                }
            default:
                System.out.println("Oh no, not that. Try something that makes more sense.");
                break;
        }
    }

    public void basementLoop(String toDo) {
        Monster ghost = new Ghost();
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
            case "open trunk":
                ghost.introduceMonster();
                fightTheGhost();
                break;
            case "take":
                System.out.println("Take what?");
                System.out.print(">");
                String takeWhat = userInput.nextLine().toLowerCase().trim();
                switch (takeWhat) {
                    case "quit":
                        System.out.println("Awww...too scary for you? Ok, bye for now.");
                        System.exit(0);
                        break;
                    case "help":
                        printCommandList();
                        break;
                    case "inventory":
                        InventoryStuff.printInventory();
                        break;
                    case "hammer":
                        InventoryStuff.addToInventory("hammer");
                        break;
                    case "chainsaw":
                        InventoryStuff.addToInventory("chainsaw");
                        break;
                    case "oil can":
                        InventoryStuff.addToInventory("oil can");
                        break;
                    case "telephone":
                        InventoryStuff.addToInventory("telephone");
                        break;
                    default:
                        System.out.println("Nope, try again.");
                        break;
                }
                break;
            case "take hammer":
                InventoryStuff.addToInventory("hammer");
                break;
            case "take chainsaw":
                InventoryStuff.addToInventory("chainsaw");
                break;
            case "take oil can":
                InventoryStuff.addToInventory("oil can");
                break;
            case "take telephone":
                InventoryStuff.addToInventory("telephone");
                break;
            case "open":
                System.out.println("What do you want to open?");
                System.out.print(">");
                String whatToOpen = userInput.nextLine().toLowerCase().trim();
                switch (whatToOpen) {
                    case "quit":
                        System.out.println("Awww...too scary for you? Ok, bye for now.");
                        System.exit(0);
                        break;
                    case "help":
                        printCommandList();
                        break;
                    case "inventory":
                        InventoryStuff.printInventory();
                        break;
                    case "trunk":
                        ghost.introduceMonster();
                        fightTheGhost();
                        break;
                    default:
                        System.out.println("What are you doing? You can't do that. Try something else.");
                        break;
                }
                break;
            default:
                System.out.println("That's not a command. Are you still drunk? Please try again.");
                break;
        }
    }

    public void fightTheGhost() {
        Monster ghost = new Ghost();
        Scanner userInput = new Scanner(System.in);
        System.out.print(">");
        String whatToUse = userInput.nextLine();
        switch (whatToUse) {
            case "quit":
                System.out.println("Awww...too scary for you? Ok, bye for now.");
                System.exit(0);
                break;
            case "help":
                printCommandList();
                break;
            case "inventory":
                InventoryStuff.printInventory();
                break;
            case "use oil can":
                ghost.makeFriendsWithHero();
                InventoryStuff.removeFromInventory("oil can");
                whatNext();
                break;
            case "use telephone":
                ghost.monsterDies();
                InventoryStuff.removeFromInventory("telephone");
                whatNext();
                break;
            case "use chainsaw":
            case "use hammer":
                ghost.killHero();
                System.exit(0);
                break;
            case "use":
                System.out.println("What do you want to use?");
                System.out.print(">");
                String useWhat = userInput.nextLine();
                switch (useWhat) {
                    case "oil can":
                        ghost.makeFriendsWithHero();
                        InventoryStuff.removeFromInventory("oil can");
                        whatNext();
                        break;
                    case "telephone":
                        ghost.monsterDies();
                        InventoryStuff.removeFromInventory("telephone");
                        whatNext();
                        break;
                    case "hammer":
                    case "chainsaw":
                        ghost.killHero();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("I'm afraid that's not possible. Try something you can actually do.");
                        break;
                }
            default:
                System.out.println("Oh no, not that. Try something that makes more sense.");
                break;
        }
    }


        
    public static void printCommandList(){
        System.out.println("******************************************");
        System.out.println("AVAILABLE COMMANDS ARE:\nGo\nUse\nOpen\nTake\nInventory\nHelp (to see list again)\nQuit (to end game)");
        System.out.println("******************************************");
    }
}


