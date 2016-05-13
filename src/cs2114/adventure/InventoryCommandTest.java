package cs2114.adventure;

import student.testingsupport.PrintWriterWithHistory;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * The test class for InventoryCommand class.
 *
 * @author Sheng Zhou
 * @version Feb 13, 2013
 */

public class InventoryCommandTest
    extends TestCase
{
    /**
     * The method is to test InventoryCommand.
     */
    public void testInventoryCommand()
    {
        MyPlayer player = new MyPlayer();
        // Now create a room, and put the player and items in the room...
        MyRoom room1 = new MyRoom("new room");
        Item daisy = new Item("daisy", 1);
        Item sword = new Item("sword", 50);
        room1.addItem(sword);
        room1.addItem(daisy);
        player.setCurrentRoom(room1);


        // Create the command and give it some arguments:
        InventoryCommand command = new InventoryCommand();

        // Execute the command:
        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.execute(player, writer);

        // Now you can either use the assertion below to check that the
        // expected output was generated, or you can write asserts based
        // on the contents of the item lists in the room and the player.

        assertTrue(writer.getHistory().contains("Your inventory is empty."));

        player.takeItem(daisy);
        command.execute(player, writer);

        assertTrue(writer.getHistory().contains(
            "You have following items in your inventory: " + " daisy"));

    }
}
