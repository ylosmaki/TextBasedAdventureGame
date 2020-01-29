package HauntedHouse;

import HauntedHouse.Monster;

import java.net.Inet4Address;

public class Zombie implements Monster {
    @Override
    public void introduceMonster() {

    }

    @Override
    public void killHero() {
        System.out.println("It seems you didn't quite have the brains to work this puzzle out.\n" +
                "The zombie doesn't find this unappetising though, and decides that your brains will do just fine for his next meal.\n" +
                "No more puzzles for you....for now.");
        System.exit(0);
    }

    @Override
    public void makeFriendsWithHero() {
        System.out.println("A fine solution. Turns out this zombie has been crying out for some intellectual stimulation.\n" +
                "He tosses you the key and gets to work on solving the brain-teasers.");
        InventoryStuff.addKey();
    }


    @Override
    public void monsterDies() {
        System.out.println("Your cruelty has paid off. Exposure to such a barrage of bad humour has melted\n" +
                "the zombie's brain. He oozes into a puddle on the floor and you retrieve the sticky key.");
        InventoryStuff.addKey();

    }
}
