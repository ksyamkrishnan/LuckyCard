import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {
    @Test
    public void getTopEndValue() {
        Card cardA = DependencyInjector.provideCard("A");
        Card cardB =DependencyInjector.provideCard("Q");
        Card cardC = DependencyInjector.provideCard("4");
        assertTrue(cardA.getTopEndValue() == 14);
        assertTrue(cardB.getTopEndValue() == 12);
        assertTrue(cardC.getTopEndValue() == 4);
    }

    @Test
    public void testEquals() {
        Card cardA = DependencyInjector.provideCard("A");
        Card cardQ =DependencyInjector.provideCard("Q");
        assertFalse(cardA.equals(cardQ));

        Card cardC =DependencyInjector.provideCard("A");
        assertTrue(cardA.equals(cardC));
    }
}