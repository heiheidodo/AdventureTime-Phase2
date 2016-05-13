package cs2114.adventure;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * The test case for MyPlayer class.
 *
 * @author Sheng Zhou
 * @version Feb 4, 2013
 */
public class MyPlayerTest
    extends TestCase
{
    private Item     testItem1;
    private Item     testItem2;
    private MyPlayer aplayer;


    // ----------------------------------------------------------
    /**
     * Sets up the test fixture. Called before every test case method.
     */
    public void setUp()
    {
        testItem1 = new Item("sword", 100.0);
        testItem2 = new Item("book", 0.5);
        aplayer = new MyPlayer();
    }


    // ----------------------------------------------------------
    /**
     * The method is to test takeItem method.
     */
    public void testTakeItem()
    {
        aplayer.takeItem(testItem1);
        assertTrue(aplayer.haveItem("sword"));
        assertFalse(aplayer.haveItem("book"));
    }


    // ----------------------------------------------------------
    /**
     * The method is to test DropItem method.
     */
    public void testDropItem()
    {
        aplayer.takeItem(testItem1);
        aplayer.dropItem("non existing");
        aplayer.dropItem(testItem1.getName());
        aplayer.dropItem(testItem2.getName());
        assertFalse(aplayer.haveItem("sword"));
        assertFalse(aplayer.haveItem("book"));
    }


    // ----------------------------------------------------------
    /**
     * The method is to test HaveItem method.
     */
    public void testHaveItem()
    {
        aplayer.takeItem(testItem1);
        aplayer.takeItem(testItem2);
        assertEquals(true, aplayer.haveItem("sword"));
        assertFalse(aplayer.haveItem("wand"));
    }


    // ----------------------------------------------------------
    /**
     * The method is to get Max weight.
     */
    public void testGetWeight()
    {
        assertEquals(100.0, aplayer.getWeight(), 0.01);
    }


    // ----------------------------------------------------------
    /**
     * The method is to test if player can carry more.
     */
    public void testCanCarry()
    {
        aplayer.takeItem(testItem2);
        assertTrue(aplayer.canCarry(testItem2));
        assertFalse(aplayer.canCarry(testItem1));
    }


    // ----------------------------------------------------------
    /**
     * The method is to test empty method.
     */
    public void testEmpty()
    {
        assertTrue(aplayer.empty(aplayer.getPlayerItem()));
    }

}
