package cs2114.adventure;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Test class for item class.
 *
 *  @author Sheng Zhou (zsheng2)
 *  @version Feb 4, 2013
 */
public class ItemTest extends TestCase
{
    private Item testItem1;
    private Item testItem2;

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture. Called before every test case method.
     */
    public void setUp()
    {
        testItem1 = new Item ("book", 0.5);
        testItem2 = new Item ("sword", 5.0);
    }

    // ----------------------------------------------------------
    /**
     * The methos is to test getName method.
     */
    public void testgetName()
    {
        assertEquals("book", testItem1.getName());
    }

    // ----------------------------------------------------------
    /**
     * The method is to test setName method.
     */
    public void testSetName()
    {
        testItem1.setName("wand");
        assertEquals("wand", testItem1.getName());
    }

    // ----------------------------------------------------------
    /**
     * The method is to test getWeight method.
     */
    public void testGetWeight()
    {
        assertEquals(0.5, testItem1.getWeight(), 0.01);
    }

    // ----------------------------------------------------------
    /**
     * The method is to test setWeight method.
     */
    public void testSetWeight()
    {
        testItem2.setWeight(4.5);
        assertEquals(4.5, testItem2.getWeight(), 0.01);
    }

}
