package card;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DebitCardTest {

    private DebitCard card;

    @Before
    public void setUp() {
        card = new DebitCard(100.0);
    }

    @Test
    public void testTopUp() {
        card.topUp(50.0);
        assertEquals(150.0, card.getBalance(), 0.001);
    }

    @Test
    public void testPaySufficientFunds() {
        assertTrue(card.pay(50.0));
        assertEquals(50.0, card.getBalance(), 0.001);
    }

    @Test
    public void testPayInsufficientFunds() {
        assertFalse(card.pay(150.0));
        assertEquals(100.0, card.getBalance(), 0.001);
    }

    @Test
    public void testGetBalance() {
        assertEquals(100.0, card.getBalance(), 0.001);
    }

}