package HauntedHouse;

import HauntedHouse.Monster;


public class Mummy implements Monster {
    @Override
    public void introduceMonster() {
        System.out.println("You lift the lid of the drier and out pops a confused and annoyed mummy, covered in blood-stained\n" +
                "bandages. How to unravel this problem?");
    }

    @Override
    public void killHero() {
        System.out.println("You haven't managed to work your way out of this bind. The mummy winds its bandages tightly around your body.\n" +
                "You fall to the floor and wheeze your last breath.\n" +
                "Time to go home to your mummy....for now.");
        System.exit(0);
    }

    @Override
    public void makeFriendsWithHero() {
        System.out.println("A sane and sanitary solution. The mummy has been looking for that bleach everywhere to get their\n" +
                "bandages back to a whiter white. The mummy hands over their key and gets to work on their laundry.");
        InventoryStuff.addKey();
    }


    @Override
    public void monsterDies() {
        System.out.println("You've cut to the right solution. A few swift snips with your mighty scissors, and the mummy\n" +
                "is nothing but a pile of strips on the floor. You retrieve the key from the crusty pile of bandage strips.");
        InventoryStuff.addKey();
    }
}
