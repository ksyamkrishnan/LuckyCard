import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {

    List<Player> players;
    List<Card> cardsOnDeck;

    public Game(List<Player> playerList, List<Card> deckOfCards) {
        this.players = playerList;
        this.cardsOnDeck = deckOfCards;
    }

    void playGame(){
        distributeCardsToPlayer();
        predictWinner(players);
    }

    void distributeCardsToPlayer(){
        for(Player player: players){
            for(int i=0;i<3;i++){
                int max = cardsOnDeck.size();
                int randomIndex = getRandomNumberInRange(0,max);
                player.cardsOnHand.add(cardsOnDeck.get(randomIndex));
                cardsOnDeck.remove(randomIndex);
            }
        }
    }

   /* void distributeCardsToPlayer(){
        players.get(0).cardsOnHand.add(cardsOnDeck.get(0));
        players.get(0).cardsOnHand.add(cardsOnDeck.get(0));
        players.get(0).cardsOnHand.add(cardsOnDeck.get(0));

        players.get(1).cardsOnHand.add(cardsOnDeck.get(0));
        players.get(1).cardsOnHand.add(cardsOnDeck.get(0));
        players.get(1).cardsOnHand.add(cardsOnDeck.get(0));

        players.get(2).cardsOnHand.add(cardsOnDeck.get(0));
        players.get(2).cardsOnHand.add(cardsOnDeck.get(0));
        players.get(2).cardsOnHand.add(cardsOnDeck.get(0));

        players.get(3).cardsOnHand.add(cardsOnDeck.get(0));
        players.get(3).cardsOnHand.add(cardsOnDeck.get(0));
        players.get(3).cardsOnHand.add(cardsOnDeck.get(0));

    }*/

    void predictWinner(List<Player> playerList) {
        Collections.sort(playerList, Collections.reverseOrder());
        int topRank = playerList.get(0).getRank();
        List<Player> topPlayers = getPlayersWithRank(topRank, playerList);
        if (topPlayers.size() == 1) {
            System.out.println("Winner is " + topPlayers.get(0).name + " with rank + " + topPlayers.get(0).getRank());
        } else { // tie players
            drawUtilWin(topPlayers);
        }
    }

    // draw cards from the deck
    void drawUtilWin(List<Player> playerList){
        for(Player player: playerList){
            int max = cardsOnDeck.size();
            int randomIndex = getRandomNumberInRange(0,max);
            player.cardsOnHand.clear();
            player.cardsOnHand.add(0, cardsOnDeck.get(randomIndex));
            cardsOnDeck.remove(randomIndex);
        }
        predictWinner(playerList);
    }

    // get players with rank
    private List<Player> getPlayersWithRank(int topRank, List<Player> playerList) {
        List<Player> topPlayerList = new ArrayList<>();
        for(Player player: playerList){
            if(player.getRank() == topRank){
                topPlayerList.add(player);
            }
        }
        return topPlayerList;
    }

    // get random number
    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
