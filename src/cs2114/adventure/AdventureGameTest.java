package cs2114.adventure;
import student.testingsupport.PrintWriterWithHistory;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  The class is for test several functions using in the game class.
 *
 *  @author Sheng Zhou
 *  @version Feb 13, 2013
 */
public class AdventureGameTest extends TestCase
{
    // ----------------------------------------------------------
    /**
     * The method is to test the Game.
     */
    public void testAdventureGame()
    {
        AdventureGame game = new AdventureGame();
        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        game.useWriter(writer);
        assertTrue(game.interpret("quit"));
    }

    // ----------------------------------------------------------
    /**
     * The method is to test welcome message.
     */
    public void testWelcomMessage()
    {
        AdventureGame game = new AdventureGame();
        assertEquals(game.welcomeMessage(), "Welcome to The World of Zuul!\n"
            + "The World of Zuul is a new, incredibly boring adventure game.\n"
            + "Type 'help' if you need help.");
    }
}
