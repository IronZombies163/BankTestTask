package card;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CashbackDebitCardTest {

    private CashbackDebitCard card;

    @Before
    public void setUp() {
        card = new CashbackDebitCard(100.0, "Groceries");
    }

    @Test
    public void testPayWithinBalance() {
        assertTrue(card.pay(50.0));
        assertEquals(50.0 + 50.0 * 0.03, card.getBalance(), 0.001);
    }

    @Test
    public void testPayExceedingBalance() {
        assertFalse(card.pay(150.0));
        assertEquals(100.0, card.getBalance(), 0.001);
    }

    @Test
    public void testGetAvailableFunds() {
        String expected = "Баланс: 100.0\nКатегория покупки: Groceries\nКешбек: 3.0%";
        assertEquals(expected, card.getAvailableFunds());
    }

    @Test
    public void testDetermineCashbackRate() {
        assertEquals(0.03, card.determineCashbackRate("Groceries"), 0.001);
        assertEquals(0.02, card.determineCashbackRate("Gas"), 0.001);
        assertEquals(0.05, card.determineCashbackRate("Dining"), 0.001);
        assertEquals(0.04, card.determineCashbackRate("Travel"), 0.001);
        assertEquals(0.01, card.determineCashbackRate("Other"), 0.001);
    }
}