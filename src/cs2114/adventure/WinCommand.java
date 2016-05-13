package cs2114.adventure;

import java.io.PrintWriter;

// -------------------------------------------------------------------------
/**
 * This command is to check if you win the game.
 *
 * @author Sheng Zhou
 * @version Feb 13, 2013
 */
public class WinCommand
    extends Command
{

    /**
     * The method is to execute the player if win.
     *
     * @param aplayer
     *            a player object
     * @param writer
     *            writer to screen
     * @return true if win, otherwise false
     */
    public boolean execute(Player aplayer, PrintWriter writer)
    {
        MyPlayer newplayer = (MyPlayer)aplayer;
        if (newplayer.getCurrentRoom().getShortDescription()
            .equals("on the star for marauder"))
        {
            if (newplayer.haveItem("daisy"))
            {
                if (newplayer.haveItem("mithrilskull1"))
                {
                    if (newplayer.haveItem("mithrilskull2"))
                    {
                        if (newplayer.haveItem("mithrilskull3"))
                        {
                            if (newplayer.haveItem("mithrilskull4"))
                            {
                                writer.println(
                                    "Congratulations! You win the game!");
                                return true;
                            }
                            else
                            {
                                writer.println(
                                    "You need to have mithrilskull4");
                            }
                        }
                        else
                        {
                            writer.println("You need to have mithrilskull3");
                        }
                    }
                    else
                    {
                        writer.println("You need to have mithrilskull2");
                    }
                }
                else
                {
                    writer.println("You need to have mithrilskull1");
                }
            }
            else
            {
                writer.println("You need to have daisy");
            }
        }
        else
        {
            writer.println("You should be in died space");
        }

        return false;
    }
}
