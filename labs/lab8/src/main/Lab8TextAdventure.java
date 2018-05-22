package main;

// Hw8TextAdventureDemo.java
// Written in class on 5-Nov-09

// This code was written in class, and so it may
// contain bugs, and its style is not exactly up to par
// (for example, we didn't comment anything!)

// Todo:

// #1) Add well-chosen helper methods to the play() method so it's
//     less unruly.  For example, a method to print what you can
//     see, another to print what you can carry.  Also, add the
//     helper method doCommand that takes a verb and a noun.
//     Note: for this step you are not adding new code, just placing
//     existing code into well-chosen helper methods.

// #2) Have the game print out the available exits before each
//     command.  After "I can see" and "I am carrying", add the
//     line "Available exits:" followed by a comma-separated list of
//     legal directions to exit the current room (or "None!" if appropriate).
//     This should also be placed in a well-chosen helper method, of course!

// #3) Allow the player to carry more than one thing
//     (that is, make "inventory" an ArrayList<Thing>,
//      see how the Room class stores Things for details)

// #4) Add a "put" method, so the player can put things down

// #5) Add an "immovable" property (instance variable) to Things.  Make it so
//     that if immovable is set to true, then that Thing may not be picked up
//     with a "get" command.  Make the sleepingStudent immovable, so if the
//     player types "get sleepingStudent", the game prints out "I can't seem
//     to do that!" and the student remains in ghc4401.

// #6) Add a cat in ghc4401 and a canary in the lobby.  These are movable.
//     Make it so that if the cat and canary are left together in a room (so
//     the player moves one into a room with the other, then puts it down, then
//     leaves), then the cat eats the canary (so the game prints out a message
//     about the cat eating the canary and removes the canary from that room).

// #7) Add at least two more verbs and two more things of your choosing.

// #8) Add a way to win the game and at least two ways to lose the game.
//     It need not be too clever, but winning must require several steps
//     with a very simple "puzzle" to solve.  Losing can happen many ways
//     (like waking a sleeping dragon, eating something poisonous, etc).

import java.util.*;

class Lab8TextAdventure {
    public static void main(String[] args) {
        TextAdventure game = new TextAdventure();
        game.play();
    }
}

class TextAdventure {
    private Room currentRoom;
    private Thing inventory;

    public TextAdventure() {
        Room ghc4401 = new Room("GHC 4401");
        ghc4401.addThing(new Thing("lectern"));
        ghc4401.addThing(new Thing("sleepingStudent"));
        this.currentRoom = ghc4401;
        Room lobby = new Room("GHC 4th Floor lobby");
        ghc4401.setExit(Direction.WEST, lobby);
        Room hiddenCloset = new Room("Scary hidden closet");
        lobby.setExit(Direction.SOUTH, hiddenCloset, false);
        hiddenCloset.setExit(Direction.SOUTH, ghc4401, false);
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nI am in " + this.currentRoom);
            System.out.print("I can see: ");
            int thingCount = this.currentRoom.getThingCount();
            if (thingCount == 0)
                System.out.println("Nothing!");
            else {
                for (int i=0; i<thingCount; i++) {
                    if (i > 0) System.out.print(", ");
                    System.out.print(this.currentRoom.getThing(i));
                }
                System.out.println();
            }
            System.out.println("I am carrying: " +
                    ((inventory == null) ? "Nothing!" : inventory));
            System.out.print("\nCommand --> ");
            String[] cmd = scanner.nextLine().split(" ");
            String verb = cmd[0];
            String noun = (cmd.length > 1 ? cmd[1] : "");
            if (verb.equals("go")) doGo(noun);
            else if (verb.equals("get")) doGet(noun);
            else if (verb.equals("quit")) break;
            else System.out.println("Unknown command: " + verb);
        }
        System.out.println("\nYou Win!!!!  Bye!!!\n");
    }

    public void doGet(String thingName) {
        Thing thing = currentRoom.getThing(thingName);
        if (thing == null)
            System.out.println("I don't see it here!");
        else if (inventory != null)
            System.out.println("I can only carrry one thing!");
        else {
            currentRoom.removeThing(thing);
            inventory = thing;
        }
    }

    public void doGo(String dirName) {
        Direction dir = Direction.getDirection(dirName);
        if (dir == null)
            System.out.println("There is no such direction!");
        else
            doGo(dir);
    }

    public void doGo(Direction dir) {
        Room room = this.currentRoom.getExit(dir);
        if (room == null)
            System.out.println("I cannot go in that direction!");
        else
            this.currentRoom = room;
    }
}

class Thing {
    private String name;
    public Thing(String name) {
        this.name = name;
    }
    public String getName() { return this.name; }
    public String toString() { return this.name; }
}

class Room {
    private String name;
    private ArrayList<Exit> exits;
    private ArrayList<Thing> things;

    public Room(String name) {
        this.name = name;
        exits = new ArrayList<Exit>();
        things = new ArrayList<Thing>();
    }

    public Thing getThing(int i) {
        return things.get(i);
    }

    public Thing getThing(String thingName) {
        for (Thing thingInRoom : things)
            if (thingInRoom.getName().equals(thingName))
                return thingInRoom;
        return null;
    }

    public int getThingCount() {
        return things.size();
    }

    public void addThing(Thing thing) {
        things.add(thing);
    }

    public boolean containsThing(Thing thing) {
        for (Thing thingInRoom : things)
            if (thingInRoom.equals(thing))
                return true;
        return false;
    }

    public void removeThing(Thing thing) {
        things.remove(thing);
    }

    public void setExit(Direction dir, Room room, boolean addReverseExit) {
        exits.add(new Exit(dir, room));
        if (addReverseExit == true) {
            room.setExit(dir.oppositeDir(), this, false);
        }
    }

    public void setExit(Direction dir, Room room) {
        setExit(dir, room, true);
    }

    public Room getExit(Direction dir) {
        for (Exit exit : exits)
            if (exit.getDirection().equals(dir))
                return exit.getRoom();
        return null;
    }

    public String toString() {
        return this.name;
    }
}

class Exit {
    private Direction dir;
    private Room room;

    public Exit(Direction dir, Room room) {
        this.dir = dir;
        this.room = room;
    }

    public Direction getDirection() { return this.dir; }

    public Room getRoom() { return this.room; }
}

class Direction {
    public static final Direction EAST  = new Direction();
    public static final Direction WEST  = new Direction();
    public static final Direction NORTH = new Direction();
    public static final Direction SOUTH = new Direction();

    public static Direction getDirection(String dirname) {
        dirname = dirname.toLowerCase();
        if (dirname.equals("north")) return NORTH;
        if (dirname.equals("south")) return SOUTH;
        if (dirname.equals("east"))  return EAST;
        if (dirname.equals("west"))  return WEST;
        return null;
    }

    public Direction oppositeDir() {
        if (this == EAST) return WEST;
        if (this == WEST) return EAST;
        if (this == NORTH) return SOUTH;
        if (this == SOUTH) return NORTH;
        return null;
    }
}
