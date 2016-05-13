package cs2114.adventure;

import java.util.Scanner;
import student.testingsupport.PrintWriterWithHistory;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * The test class for DropItemCommand class.
 *
 * @author Sheng Zhou
 * @version Feb 13, 2013
 */

public class DropItemCommandTest
    extends TestCase
{
    // ----------------------------------------------------------
    /**
     * The method is to test DropItemCommand.
     */
    public void testDropItemCommand()
    {
        MyPlayer player = new MyPlayer();
        // Now create a room, and put the player and items in the room...
        MyRoom room1 = new MyRoom("new room");
        Item daisy = new Item("daisy", 1);
        Item sword = new Item("sword", 50);
        player.setCurrentRoom(room1);
        player.takeItem(daisy);
        player.takeItem(sword);

        // Create the command and give it some arguments:
        DropItemCommand command = new DropItemCommand();
        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.readArguments(new Scanner(" "));
        command.execute(player, writer);
        assertTrue(writer.getHistory().contains("Drop what?"));

        command.readArguments(new Scanner("daisy"));

        // Execute the command:
        command.execute(player, writer);

        // Now you can either use the assertion below to check that the
        // expected output was generated, or you can write asserts based
        // on the contents of the item lists in the room and the player.
        assertTrue(writer.getHistory().contains("You have dropped off daisy."));

        player.dropItem("daisy");
        command.execute(player, writer);
        assertTrue(writer.getHistory().contains(
            "There is no such item in your inventory."));
    }


}
