import java.util.List;

public class Player implements Comparable<Player> {
    String name;
    List<Card> cardsOnHand;

    public Player(String name, List<Card> cardsOnHand) {
        this.name = name;
        this.cardsOnHand = cardsOnHand;
    }

    int getRank() {
        return RankCalculatorUtil.getRank(cardsOnHand);
    }

    @Override
    public int compareTo(Player o) {
        return (this.getRank() - o.getRank());
    }
}
