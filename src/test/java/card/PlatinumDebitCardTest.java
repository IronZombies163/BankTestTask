package card;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlatinumDebitCardTest {

    private PlatinumDebitCard card;

    @Before
    public void setUp() {
        card = new PlatinumDebitCard(10000.0);
    }

    @Test
    public void testPayWithinBalanceUnder5000() {
        assertTrue(card.pay(2000.0));
        assertEquals(8000.0, card.getBalance(), 0.001);
        assertEquals(2000.0 * 0.05, card.getCashbackAmount(), 0.001);
    }

    @Test
    public void testPayWithinBalanceOver5000() {
        assertTrue(card.pay(6000.0));
        assertEquals(4000.0, card.getBalance(), 0.001);
        assertEquals(6000.0 * 0.25, card.getCashbackAmount(), 0.001);
    }

    @Test
    public void testPayExceedingBalance() {
        assertFalse(card.pay(12000.0));
        assertEquals(10000.0, card.getBalance(), 0.001);
        assertEquals(0.0, card.getCashbackAmount(), 0.001);
    }

    @Test
    public void testTopUp() {
        card.topUp(500.0);
        assertEquals(10500.0, card.getBalance(), 0.001);
        assertEquals(500.0 * 0.00005, card.getCashbackAmount(), 0.001);
    }

    @Test
    public void testGetAvailableFunds() {
        String expected = "Баланс: 10000.0"+"\nСколько накопили кэшбека: 0.0";
        assertEquals(expected, card.getAvailableFunds());
    }
}