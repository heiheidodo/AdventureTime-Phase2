package cs2114.adventure;

// -------------------------------------------------------------------------
/**
 * The class is the main body for the game which provides several types of
 * commands.
 *
 * @author Sheng Zhou
 * @version Feb 10, 2013
 */
public class AdventureGame
    extends Game
{
    // ----------------------------------------------------------
    /**
     * Create a new AdventureGame object.
     */
    public AdventureGame()
    {
        super(new MyPlayer());
    }


    /**
     * Create a welcome message in type String.
     *
     * @return a welcome message
     */
    public String welcomeMessage()
    {
        return "Welcome to The World of Zuul!\n"
            + "The World of Zuul is a new, incredibly boring adventure game.\n"
            + "Type 'help' if you need help.";
    }


    /**
     * Create rooms for the game.
     */
    public void createRooms()
    {
        // Create the rooms.
        MyRoom outside = new MyRoom("outside McBryde Hall");
        MyRoom lab = new MyRoom("in a computing lab");
        MyRoom drillfield = new MyRoom("on a vast empty field");
        MyRoom spaceship = new MyRoom("near drillfield");
        MyRoom outerspace = new MyRoom("outside the earth");
        MyRoom miranda = new MyRoom("on a star on the edge of the universe");
        MyRoom moon = new MyRoom("in the base for the universe union");
        MyRoom diedspace = new MyRoom("on the star for marauder");

        // Create an item and add it to a room.
        // The lab is the base for any weapons and for creating new useful
        // items.
        Item sword = new Item("sword", 10);
        Item hcl = new Item("hcl", 6);
        Item fe2o3 = new Item("fe2o3", 1);
        Item key2labdoor = new Item("keyl", 1);
        lab.addItem(sword);
        lab.addItem(hcl);
        lab.addItem(fe2o3);
        lab.addItem(key2labdoor);

        // The spaceship has many items in it.
        Item desk = new Item("desk", 30);
        Item crystal = new Item("crystal", 3);
        Item blackhole = new Item("blackhole", 1000);
        Item mithrilskull1 = new Item("mithrilskull1", 20);
        spaceship.addItem(desk);
        spaceship.addItem(crystal);
        spaceship.addItem(blackhole);
        spaceship.addItem(mithrilskull1);

        // There is only one weapon and one skull on drillfield.
        Item mithrilskull2 = new Item("mithrilskull2", 20);
        Item rifle = new Item("rifle", 60);
        drillfield.addItem(mithrilskull2);
        drillfield.addItem(rifle);

        // There are only comas in outer space.
        Item coma1 = new Item("hugecoma", 400);
        Item coma2 = new Item("tinycoma", 14);
        outerspace.addItem(coma1);
        outerspace.addItem(coma2);

        // There are some things outside.
        Item daisy = new Item("daisy", 1);
        Item rafflesia = new Item("rafflesia", 3);
        outside.addItem(daisy);
        outside.addItem(rafflesia);

        // There are some objects on miranda.
        Item key2miranda = new Item("keym", 1);
        Item capsule = new Item("capsule", 1);
        Item mithrilskull3 = new Item("mithrilskull3", 20);
        miranda.addItem(key2miranda);
        miranda.addItem(capsule);
        miranda.addItem(mithrilskull3);

        // Universal union's base is moon.
        Item key2union = new Item("keyu", 1);
        Item mithrilskull4 = new Item("mithrilskull4", 20);
        Item wand = new Item("wand", 4);
        moon.addItem(key2union);
        moon.addItem(mithrilskull4);
        moon.addItem(wand);

        // Also, there are some unknows objects in the died space.
        Item zombiesaliva = new Item("zombiesaliva", 1);
        Item gelsemiumelegans = new Item("gelsemiumelegans", 1);
        diedspace.addItem(zombiesaliva);
        diedspace.addItem(gelsemiumelegans);

        // Link up the rooms using their exits.
        outside.setExit("south", lab);
        lab.setExit("north", outside);
        lab.setExit("west", miranda);
        miranda.setExit("east", lab);
        miranda.setExit("southeast", diedspace);
        diedspace.setExit("northwest", miranda);
        miranda.setExit("east", spaceship);
        spaceship.setExit("west", miranda);
        spaceship.setExit("east", outerspace);
        outerspace.setExit("west", spaceship);
        outerspace.setExit("east", moon);
        moon.setExit("west", outerspace);
        lab.setExit("spacestation", moon);
        moon.setExit("spacestation", lab);
        outside.setExit("east", drillfield);
        drillfield.setExit("west", outside);
        drillfield.setExit("north", spaceship);
        spaceship.setExit("landing", drillfield);
        moon.setExit("south", diedspace);
        diedspace.setExit("north", moon);
        diedspace.setExit("southwest", outerspace);
        outerspace.setExit("northeast", diedspace);
        spaceship.setExit("tunnel", diedspace);

        // Put the player in the room where they should start.
        player().setCurrentRoom(outside);
    }


    /**
     * Create commands using for the game.
     */
    public void createCommands()
    {
        CommandWords commands = commandWords();
        commands.addCommand("go", new GoCommand());
        commands.addCommand("help", new HelpCommand(commands));
        commands.addCommand("quit", new QuitCommand());
        commands.addCommand("take", new TakeItemCommand());
        commands.addCommand("drop", new DropItemCommand());
        commands.addCommand("inventory", new InventoryCommand());
        commands.addCommand("win", new WinCommand());
    }

}
