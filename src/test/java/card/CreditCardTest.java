package card;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class CreditCardTest extends TestCase {

    private CreditCard card;

    @Before
    public void setUp() {
        card = new CreditCard(100.0, 200.0);
    }
    @Test
    public void testTopUpWithinCreditLimit() {

        card.topUp(50.0);
        assertEquals(150.0, card.getBalance(), 0.001);
        assertEquals(200.0, card.getCreditMoney(), 0.001);
    }

    @Test
    public void testTopUpExceedingCreditLimit() {

        card.topUp(250.0);
        assertEquals(350.0, card.getBalance(), 0.001);
        assertEquals(200.0, card.getCreditMoney(), 0.001);
    }

    @Test
    public void testPayWithSufficientFunds() {

        assertTrue(card.pay(50.0));
        assertEquals(50.0, card.getBalance(), 0.001);
    }

    @Test
    public void testPayWithCreditMoney() {

        card.pay(300.0);
        assertEquals(0.0, card.getBalance(), 0.001);
        assertEquals(0.0, card.getCreditMoney(), 0.001);
    }

    @Test
    public void testPayInsufficientFunds() {
        assertFalse(card.pay(400.0));
        assertEquals(100.0, card.getBalance(), 0.001);
        assertEquals(200.0, card.getCreditMoney(), 0.001);
    }
}