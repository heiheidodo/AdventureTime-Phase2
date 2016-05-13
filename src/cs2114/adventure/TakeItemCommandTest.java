package cs2114.adventure;

import java.util.Scanner;
import student.testingsupport.PrintWriterWithHistory;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * The test class for TakeItemCommand class.
 *
 * @author Sheng Zhou
 * @version Feb 13, 2013
 */

public class TakeItemCommandTest
    extends TestCase
{

    // ----------------------------------------------------------
    /**
     * The method is to test TakeItemCommand.
     */
    public void testTakeItemCommand()
    {
        MyPlayer player = new MyPlayer();
        // Now create a room, and put the player and items in the room...
        MyRoom room1 = new MyRoom("new room");
        Item daisy = new Item("daisy", 1);
        Item sword = new Item("sword", 500);
        player.setCurrentRoom(room1);
        room1.addItem(daisy);
        room1.addItem(sword);

        // Create the command and give it some arguments:
        TakeItemCommand command = new TakeItemCommand();
        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.readArguments(new Scanner(" "));
        command.execute(player, writer);
        assertTrue(writer.getHistory().contains("Take what?"));

        command.readArguments(new Scanner("daisy"));

        // Execute the command:
        command.execute(player, writer);

        // Now you can either use the assertion below to check that the
        // expected output was generated, or you can write asserts based
        // on the contents of the item lists in the room and the player.
        assertTrue(writer.getHistory().contains("You have picked up daisy."));

        command.readArguments(new Scanner("sword"));
        PrintWriterWithHistory awriter = new PrintWriterWithHistory();
        command.execute(player, awriter);
        assertTrue(awriter.getHistory().contains(
            "There is no space for you to carry sword."));

        command.readArguments(new Scanner("mirror"));
        command.execute(player, awriter);
        assertTrue(awriter.getHistory().contains(
            "There is no such item in the room."));
    }
}
