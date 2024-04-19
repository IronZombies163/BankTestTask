package card;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GoldCreditCardTest {

    private GoldCreditCard card;

    @Before
    public void setUp() {
        card = new GoldCreditCard(5000.0, 10000.0);
    }

    @Test
    public void testPayWithSufficientBalance() {
        assertTrue(card.pay(3000.0));
        assertEquals(2000.0, card.getBalance(), 0.001);
        assertEquals(10000.0, card.getCreditMoney(), 0.001);
        assertEquals(0.0, card.getCashbackAmount(), 0.001);
    }

    @Test
    public void testPayWithInsufficientBalance() {
        assertFalse(card.pay(16000.0));
        assertEquals(5000.0, card.getBalance(), 0.001);
        assertEquals(10000.0, card.getCreditMoney(), 0.001);
        assertEquals(0.0, card.getCashbackAmount(), 0.001);
    }

    @Test
    public void testTopUpWithinCreditLimit() {
        card.topUp(3000.0);
        assertEquals(8000.0, card.getBalance(), 0.001);
        assertEquals(10000.0, card.getCreditMoney(), 0.001);
    }

    @Test
    public void testTopUpExceedingCreditLimit() {
        card.topUp(15000.0);
        assertEquals(10000.0, card.getCreditMoney(), 0.001);
        assertEquals(20000.0, card.getBalance(), 0.001);
    }

    @Test
    public void testGetAvailableFunds() {
        String expected = "Кредитный лимит: 10000.0\nКредитные средства: 10000.0\nБаланс: 5000.0\nНакопленно кешбэка: 0.0";
        assertEquals(expected, card.getAvailableFunds());
    }
}