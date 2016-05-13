package cs2114.adventure;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * The class is a player class which is to check several peroperties.
 *
 * @author Sheng Zhou
 * @version Feb 2, 2013
 */
public class MyPlayer
    extends Player
    implements Weighable
{
    private ArrayList<Item> myItem;
    private double          capacity;


    // ----------------------------------------------------------

    // ----------------------------------------------------------
    /**
     * Create a new MyPlayer object.
     */
    public MyPlayer()
    {
        myItem = new ArrayList<Item>();
        capacity = 100.0;
    }


    /**
     * The method is to let the player take a new item.
     *
     * @param newone
     *            the new item
     */
    public void takeItem(Item newone)
    {
        myItem.add(newone);
    }


    // ----------------------------------------------------------
    /**
     * The method is to drop item.
     *
     * @param name
     *            the old item which should be dropped
     */
    public void dropItem(String name)
    {
        for (int i = 0; i < myItem.size(); i++)
        {
            if (myItem.get(i).getName().equals(name))
            {
                myItem.remove(i);
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * The method is to check if player has an item.
     *
     * @param itemName
     *            the one should be checked
     * @return true if player has the item, otherwise, false.
     */
    public boolean haveItem(String itemName)
    {
        for (int i = 0; i < myItem.size(); i++)
        {
            if (myItem.get(i).getName().equals(itemName))
            {
                return true;
            }
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * The method is to get the max weight the player can carry.
     *
     * @return the weight
     */
    public double getWeight()
    {
        // TODO Auto-generated method stub
        return capacity;
    }


    // ----------------------------------------------------------
    /**
     * The method is to check if player can take more items.
     *
     * @param itemName
     *            the one to check if player can carry
     * @return true if player can carry, otherwise, false.
     */
    public boolean canCarry(Item itemName)
    {
        double totalWeight = 0;
        for (int i = 0; i < myItem.size(); i++)
        {
            totalWeight += myItem.get(i).getWeight();

        }
        if (totalWeight + itemName.getWeight() <= capacity)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    /**
     * The method is to return items carrying by the player.
     *
     * @return myItem the items player has carried.
     */
    public ArrayList<Item> getPlayerItem()
    {
        return myItem;
    }


    // ----------------------------------------------------------
    /**
     * The method is to check if player carry nothing.
     *
     * @param items
     *            items the player carries
     * @return true if the inventory is empty, otherwise, false
     */
    public boolean empty(ArrayList<Item> items)
    {
        if (items.size() != 0)
        {
            return false;
        }
        return true;
    }
}
