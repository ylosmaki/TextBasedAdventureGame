package HauntedHouse;

public interface Monster {
    /* Actions that the monsters can do, e.g. attack, die, fail to die, make friends etc.
     */
    public void introduceMonster();

    public void killHero();

    public void makeFriendsWithHero();

    public void heroFailsToKill();

    public void monsterDies();

}
