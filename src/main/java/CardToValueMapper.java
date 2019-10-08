public class CardToValueMapper {

    static int getCardNumberValue(Card card) {
        switch (card.faceValue.toUpperCase()) {
            case "A":
                return 1;
            case "K":
                return 13;
            case "Q":
                return 12;
            case "J":
                return 11;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            default:
                return -1;
        }
    }

    public static int getTopEndValue(Card card) {
        if(card.faceValue.equalsIgnoreCase("A")){
            return 14;
        } else {
            return getCardNumberValue(card);
        }
    }
}
