import java.util.ArrayList;
import java.util.List;

public class DependencyInjector {

    public static List<Card> provideFullDeckCardList(){
        List<Card> deckOfCards = new ArrayList<>();
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (int i = 0; i < 4; i++) {
            for (int x = 0; x < ranks.length; x++) {
                Card card = new Card(ranks[x]);
                deckOfCards.add(card);
            }
        }
        return deckOfCards;
    }

    public static List<Player> providePlayerList(){
        Player player1 = new Player("Raj",new ArrayList<Card>());
        Player player2 = new Player("Ashwin",new ArrayList<Card>());
        Player player3 = new Player("Ganesh",new ArrayList<Card>());
        Player player4 = new Player("Adi",new ArrayList<Card>());
        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);
        return playerList;
    }
    public static Card provideCard(String faceNumber){
        return new Card(faceNumber);
    }

    public static Game provideGame(){
        Game game = new Game(DependencyInjector.providePlayerList(),DependencyInjector.provideFullDeckCardList());
        return game;
    }
}
