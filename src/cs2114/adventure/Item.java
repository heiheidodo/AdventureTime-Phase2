package cs2114.adventure;

// -------------------------------------------------------------------------
/**
 * The class is about items.
 *
 * @author Sheng Zhou
 * @version Feb 2, 2013
 */

class Item implements Weighable
{
    private String name;
    private double weight;


    // ----------------------------------------------------------
    /**
     * Create a new Item object.
     *
     * @param name
     *            the item's name
     * @param weight
     *            the item's weight
     */
    public Item(String name, double weight)
    {
        this.name = name;
        this.weight = weight;
    }


    // ----------------------------------------------------------
    /**
     * The method is to get the item name.
     *
     * @return the item name
     */
    public String getName()
    {
        return name;
    }


    // ----------------------------------------------------------
    /**
     * The method is to set item a new name.
     *
     * @param name
     *            item's name
     */
    public void setName(String name)
    {
        this.name = name;
    }


    // ----------------------------------------------------------
    /**
     * The method is to get the item's weight.
     *
     * @return weight the item's weight
     */
    public double getWeight()
    {
        return weight;
    }


    // ----------------------------------------------------------
    /**
     * The method is to set item weight.
     *
     * @param weight
     *            the weight of the item
     */
    public void setWeight(double weight)
    {
        this.weight = weight;
    }
}
