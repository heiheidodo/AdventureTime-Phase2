package cs2114.adventure;

import java.util.ArrayList;
import java.io.PrintWriter;

// -------------------------------------------------------------------------
/**
 * The class is to add a take item command for the game.
 *
 * @author Sheng Zhou
 * @version Feb 13, 2013
 */
public class TakeItemCommand
    extends Command
{

    /**
     * The method is to execute if player can take item and gives feedback.
     *
     * @param aplayer
     *            player obejcet
     * @param writer
     *            print on screen
     * @return false if player can take.
     */
    public boolean execute(Player aplayer, PrintWriter writer)
    {
        MyPlayer newplayer = (MyPlayer)aplayer;

        if (hasSecondWord())
        {
            String itemName = getSecondWord();

            MyRoom room = (MyRoom)newplayer.getCurrentRoom();
            ArrayList<Item> itemsInRoom = room.getRoomItem();
            for (Item item : itemsInRoom)
            {
                if ((item.getName()).equals(itemName))
                {
                    if (newplayer.canCarry(item))
                    {
                        newplayer.takeItem(item);
                        room.removeItem(itemName);
                        writer.println("You have picked up " + itemName + ".");
                        return false;
                    }
                    else
                    {
                        writer.println("There is no space for you to carry "
                            + itemName + ".");
                    }

                }
            }
            writer.println("There is no such item in the room.");
        }
        else
        {
            writer.println("Take what?");
        }

        return false;
    }
}
