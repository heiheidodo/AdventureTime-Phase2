package cs2114.adventure;

import java.util.ArrayList;
import java.io.PrintWriter;

// -------------------------------------------------------------------------
/**
 * The method is to give the player a message which contains all the items the
 * player has.
 *
 * @author Sheng Zhou
 * @version Feb 13, 2013
 */
public class InventoryCommand
    extends Command
{

    /**
     * The method is to give player the feedback of what he is carrying.
     *
     * @param aplayer
     *            player obejcet
     * @param writer
     *            print on screen
     * @return false if screen prints the objects.
     */
    public boolean execute(Player aplayer, PrintWriter writer)
    {
        MyPlayer newplayer = (MyPlayer)aplayer;
        ArrayList<Item> pocketItem = newplayer.getPlayerItem();
        String woo = new String();

        if (!newplayer.empty(pocketItem))
        {
            for (Item item : pocketItem)
            {
                woo += " " + item.getName();
            }

            writer.println("You have following items in your inventory: "
                + woo);
        }
        else
        {
            writer.println("Your inventory is empty.");
        }
        return false;
    }

}
