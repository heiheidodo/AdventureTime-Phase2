package cs2114.adventure;

import java.util.ArrayList;
import java.io.PrintWriter;

// -------------------------------------------------------------------------
/**
 * The class is to drop an item command for the game.
 *
 * @author Sheng Zhou(zsheng2)
 * @version Feb 13, 2013
 */
public class DropItemCommand
    extends Command
{

    /**
     * The method is to execute if player can drop item and gives feedback.
     *
     * @param aplayer
     *            player obejcet
     * @param writer
     *            print on screen
     * @return false if player drop the item.
     */
    public boolean execute(Player aplayer, PrintWriter writer)
    {
        MyPlayer newplayer = (MyPlayer)aplayer;

        if (hasSecondWord())
        {
            String itemName = getSecondWord();

            MyRoom room = (MyRoom)newplayer.getCurrentRoom();
            ArrayList<Item> itemscarrying = newplayer.getPlayerItem();

            for (Item item : itemscarrying)
            {
                if ((item.getName()).equals(itemName))
                {
                    newplayer.dropItem(itemName);
                    room.addItem(item);
                    writer.println("You have dropped off " + itemName + ".");
                    return false;
                }

            }
            writer.println("There is no such item in your inventory.");
        }
        else
        {
            writer.println("Drop what?");
        }

        return false;
    }
}
