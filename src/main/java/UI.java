import java.util.Scanner;

public class UI {

    /*Greeting/back-story, other text and descriptions.
     */
    Scanner userInput = new Scanner(System.in);
    InventoryStuff inventory = new InventoryStuff();

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
            System.out.print(">");
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
                    String whereTo = userInput.nextLine();
                    switch (whereTo) {
                        case "kitchen":
                            //method here
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
                            //method here
                            break;

                        default:
                            System.out.println("That's not a command. Are you still drunk? Please try again.");
                            break;

                    }
                case "inventory":
                    System.out.println(inventory);
                    break;

                case "take":


                default:
                    System.out.println("That's not a command. Are you still drunk? Please try again.");
                    break;
        }

        }

    }

        public void printCommandList () {
            System.out.println("Available commands are:\n\nLook\nGo\nUse\nOpen\nTake\nInventory\nHelp (to see list again)\nQuit (to end game)");
            //whatNext();
        }
    }


