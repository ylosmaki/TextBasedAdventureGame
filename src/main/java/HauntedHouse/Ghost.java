package HauntedHouse;

public class Ghost implements Monster {
    @Override
    public void introduceMonster() {
        System.out.println("Opening the trunk has revealed an angry-looking ghost holding a key.\n" +
                "He rattles his chains at you menacingly.");
    }

    @Override
    public void killHero() {
        System.out.println("Life is full of choices and you made the wrong one. The ghost has stolen\n" +
                "your soul and left you as an empty shell on the floor.\n" +
                "Your journey ends here....for now.");
        System.exit(0);
    }

    @Override
    public void makeFriendsWithHero() {
        System.out.println("Excellent idea. Those creaky clanking chains have been driving the ghost crazy!\n" +
                "He's so happy for the peace and quiet, he happily hands over his key.");
        InventoryStuff.addKey();

    }


    @Override
    public void monsterDies() {
        System.out.println("That was quick thinking. The Ghostbusters perform a tele-exorcism and the ghost is sucked\n" +
                "into the phone. The key drops to the floor with a clang and you scoop it up gratefully.");
        InventoryStuff.addKey();
    }
}
