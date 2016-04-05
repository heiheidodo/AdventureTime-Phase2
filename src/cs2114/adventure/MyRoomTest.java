package cs2114.adventure;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * The test class for MyRoom class.
 *
 * @author Sheng Zhou (zsheng2)
 * @version Feb 4, 2013
 */
public class MyRoomTest
    extends TestCase
{
    private Item   testItem1;
    private Item   testItem2;
    private MyRoom testRoom;


    // ----------------------------------------------------------
    /**
     * Sets up the test fixture. Called before every test case method.
     */
    public void setUp()
    {
        testItem1 = new Item("sword", 5.0);
        testItem2 = new Item("book", 0.5);
        testRoom = new MyRoom("testRoom");
    }


    // ----------------------------------------------------------
    /**
     * The method is to test Add method.
     */
    public void testAddItem()
    {
        testRoom.addItem(testItem1);
        assertTrue(testRoom.inRoom("sword"));
    }


    /**
     * // ---------------------------------------------------------- /** The
     * method is to test Remove method.
     */
    public void testRemoveItem()
    {
        testRoom.addItem(testItem1);
        testRoom.removeItem("any object");
        testRoom.removeItem(testItem1.getName());
        testRoom.removeItem(testItem2.getName());
        assertEquals(false, testRoom.inRoom("sword"));
        assertEquals(false, testRoom.inRoom("wand"));
    }


    // ----------------------------------------------------------
    /**
     * The method is to test Contains method.
     */
    public void testInRoom()
    {
        testRoom.addItem(testItem1);
        testRoom.addItem(testItem2);
        assertEquals(true, testRoom.inRoom(testItem1.getName()));
        assertEquals(false, testRoom.inRoom("anything"));
    }


    // ----------------------------------------------------------
    /**
     * The method is to test getlongdescription method.
     */
    public void testGetLongDescription()
    {
        testRoom.addItem(testItem1);
        testRoom.addItem(testItem2);
        assertTrue(testRoom.getLongDescription().contains(" sword book"));
    }

}
