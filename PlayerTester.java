
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlayerTester.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PlayerTester
{
    /**
     * Default constructor for test class PlayerTester
     */
    public PlayerTester()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void Start()
    {
        Dealer dealer = new Dealer(2);
        Player player = new Player(40000);
        for(int x = 0; x < 2; x ++) {
            Card c = dealer.dealToPlayer(player);
            System.out.println(c.getValue() + " " + c.getSuit());
            player.addCard(c);
        }
        player.hit(dealer);
        boolean d = player.getCardTotal() > 0;
        assertEquals(d,true);

    }
}

