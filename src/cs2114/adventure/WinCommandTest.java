package cs2114.adventure;

import student.testingsupport.PrintWriterWithHistory;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * The test class for WinComman class.
 *
 * @author Sheng Zhou (zsheng2)
 * @version Feb 13, 2013
 */

public class WinCommandTest
    extends TestCase
{
    // ----------------------------------------------------------
    /**
     * The method is to test WinCommand.
     */
    public void testWinCommand()
    {
        MyPlayer player = new MyPlayer();
        MyRoom diedspace = new MyRoom("on the star for marauder");
        MyRoom moon = new MyRoom("moon");
        Item mithrilskull1 = new Item("mithrilskull1", 20);
        Item mithrilskull2 = new Item("mithrilskull2", 20);
        Item mithrilskull3 = new Item("mithrilskull3", 20);
        Item mithrilskull4 = new Item("mithrilskull4", 20);
        Item daisy = new Item("daisy", 1);
        diedspace.addItem(mithrilskull1);
        diedspace.addItem(mithrilskull2);
        diedspace.addItem(mithrilskull3);
        diedspace.addItem(mithrilskull4);
        diedspace.addItem(daisy);
        player.setCurrentRoom(moon);

        WinCommand command = new WinCommand();

        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.execute(player, writer);
        assertTrue(writer.getHistory().contains("You should be in died space"));

        player.setCurrentRoom(diedspace);
        command.execute(player, writer);
        assertTrue(writer.getHistory().contains("You need to have daisy"));

        player.takeItem(daisy);
        command.execute(player, writer);
        assertTrue(writer.getHistory().contains(
            "You need to have mithrilskull1"));

        player.takeItem(mithrilskull1);
        command.execute(player, writer);
        assertTrue(writer.getHistory().contains(
            "You need to have mithrilskull2"));

        player.takeItem(mithrilskull2);
        command.execute(player, writer);
        assertTrue(writer.getHistory().contains(
            "You need to have mithrilskull3"));

        player.takeItem(mithrilskull3);
        command.execute(player, writer);
        assertTrue(writer.getHistory().contains(
            "You need to have mithrilskull4"));

        player.takeItem(mithrilskull4);
        command.execute(player, writer);
        assertTrue(writer.getHistory().contains(
            "Congratulations! You win the game!"));
    }
}
