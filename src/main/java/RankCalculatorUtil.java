import java.util.*;

// class to calculate the the rank
public class RankCalculatorUtil {

    // get the overall rank from the card list
    public static int getRank(List<Card> cardList) {
        for (int i = 0; i < cardList.size(); i++) {
            if (getAllSameRank(cardList) != -1) {
                return getAllSameRank(cardList);
            } else if (getSequentialRank(cardList) != -1) {
                return getSequentialRank(cardList);
            } else if (getPairedRank(cardList) != -1) {
                return getPairedRank(cardList);
            } else if (getTopValuedCard(cardList) != -1) {
                return getTopValuedCard(cardList);
            }
        }
        return -1;
    }

    // get rank for all same card
    static int getAllSameRank(List<Card> cardList) {
        Card temp = null;
        for (Card card : cardList) {
            if (temp == null) {
                temp = card;
            } else if (!temp.equals(card)) {
                return -1;
            }
        }
        return temp.getTopEndValue() * 1000000;
    }

    // get rank for sequential cards
    static int getSequentialRank(List<Card> cardList) {
        boolean endWithA = false;
        List<Card> newCardList = new ArrayList<Card>();
        newCardList.addAll(cardList);
        Collections.sort(newCardList);
        // logic to check the bottom end sequence with A
        if (newCardList.get(0).numberValue == 1) {
            if (newCardList.get(1).numberValue == (14 - 2)) {
                newCardList.remove(0);
                endWithA = true;
            }
        }
        int largestNumberInSequence = getLargestNumberInSequence(newCardList);
        if (largestNumberInSequence == -1) {
            return -1;
        }
        // logic to get the top end A value
        if (endWithA) {
            largestNumberInSequence++;
        }
        return largestNumberInSequence * 10000;
    }

    //  get rank for paired cards.
    static int getPairedRank(List<Card> cardList) {
        Collections.sort(cardList, Collections.reverseOrder());
        int rankValue = -1;
        for (Card card : cardList) {
            if (Collections.frequency(cardList, card) == 2) {
                rankValue = card.getTopEndValue() * 100;
                return rankValue;
            }
        }
        return rankValue;
    }

    // get value for the top card
    static int getTopValuedCard(List<Card> cardList) {
        Collections.sort(cardList, Collections.reverseOrder());
        return cardList.get(0).numberValue;
    }

    // get the largest number in the sequence
    private static int getLargestNumberInSequence(List<Card> cardList) {
        int prevVal = -1;
        for (int i = 0; i < cardList.size(); i++) {
            if (prevVal == -1) {
                prevVal = cardList.get(i).numberValue;
            } else {
                if (cardList.get(i).numberValue == prevVal + 1) {
                    prevVal = cardList.get(i).numberValue;
                } else {
                    return -1;
                }
            }
        }
        return prevVal;
    }
}
