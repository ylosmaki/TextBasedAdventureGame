package HauntedHouse;

import HauntedHouse.Monster;

import java.util.List;

public abstract class Room {
    /* Each room has their own monster and their own objects, and a hidden key. Room objects contain their description?
    Should this be an abstract class/interface?
     */
    abstract void introduceRoom();

    abstract List<String> getFurnitureYouCanOpen();

    abstract List<String> getStuffYouCanTake();

    abstract Monster getMonster();
}