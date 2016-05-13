package cs2114.adventure;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * The class is the subclass of room class which is to check several properties.
 *
 * @author Sheng Zhou
 * @version Feb 2, 2013
 */
public class MyRoom
    extends Room
{
    private ArrayList<Item> roomItem;


    // ----------------------------------------------------------
    /**
     * Create a new MyRoom object.
     *
     * @param description
     *            Room description
     */
    public MyRoom(String description)
    {
        super(description);
        roomItem = new ArrayList<Item>();
    }


    // ----------------------------------------------------------
    /**
     * The method is to add item in the room
     *
     * @param newItem
     *            new item to be added
     */
    public void addItem(Item newItem)
    {
        roomItem.add(newItem);
    }


    // ----------------------------------------------------------
    /**
     * The method is to remove item in the room
     *
     * @param itemName
     *            the one needs to be removed
     */
    public void removeItem(String itemName)
    {
        for (int i = 0; i < roomItem.size(); i++)
        {
            if (roomItem.get(i).getName().equals(itemName))
            {
                roomItem.remove(i);
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * The method is to test if the item is in the room
     *
     * @param itemName
     *            the one needs to be checked
     * @return true if item is in the room, otherwise false.
     */
    public boolean inRoom(String itemName)
    {
        for (int i = 0; i < roomItem.size(); i++)
        {
            if (roomItem.get(i).getName().equals(itemName))
            {
                return true;
            }
        }
        return false;
    }


    /**
     * The method is to return the room with items in it.
     *
     * @return describe the description
     */
    public String getLongDescription()
    {
        String describe = super.getLongDescription();
        for (Item item : roomItem)
        {
            describe += " " + item.getName();
        }
        return describe;
    }


    /**
     * The method is to return items in the room.
     *
     * @return roomItem an arrayList for the room items.
     */
    public ArrayList<Item> getRoomItem()
    {
        return roomItem;
    }

}
