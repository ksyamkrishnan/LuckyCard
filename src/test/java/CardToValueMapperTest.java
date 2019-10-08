import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardToValueMapperTest {

    @Test
    public void getCardNumberValue() {
        Card cardA = new Card("A");
        Card cardB = new Card("Q");
        Card cardC = new Card("4");
        assertTrue(CardToValueMapper.getCardNumberValue(cardA) == 1);
        assertTrue(CardToValueMapper.getCardNumberValue(cardB) == 12);
        assertTrue(CardToValueMapper.getCardNumberValue(cardC) == 4);

    }

    @Test
    public void getTopEndValue() {
        Card cardA = new Card("A");
        Card cardB = new Card("Q");
        Card cardC = new Card("4");
        assertTrue(CardToValueMapper.getTopEndValue(cardA) == 14);
        assertTrue(CardToValueMapper.getTopEndValue(cardB) == 12);
        assertTrue(CardToValueMapper.getTopEndValue(cardC) == 4);
    }
}