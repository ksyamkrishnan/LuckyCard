import java.util.Objects;

public class Card implements Comparable<Card> {
    String faceValue;
    int numberValue;

    Card(String faceValue) {
        this.faceValue = faceValue;
        this.numberValue = CardToValueMapper.getCardNumberValue(this);
    }

    @Override
    public int compareTo(Card card) {
        return this.numberValue - card.numberValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return numberValue == card.numberValue &&
                faceValue.equals(card.faceValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faceValue, numberValue);
    }

    int getTopEndValue(){
        return CardToValueMapper.getTopEndValue(this);
    }
}
