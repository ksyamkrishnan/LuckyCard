import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    Game game;
    @Test
    public void distributeCardsToPlayer() {
        game.distributeCardsToPlayer();
        assertTrue(game.players.get(0).cardsOnHand.size() == 3);
        assertTrue(game.players.get(1).cardsOnHand.size() == 3);
        assertTrue(game.players.get(2).cardsOnHand.size() == 3);
        assertTrue(game.players.get(3).cardsOnHand.size() == 3);
    }

    @Test
    public void drawCardFromDeckAndPredict() {
       game.drawCardFromDeckAndPredict(game.players);
        assertTrue(game.players.get(0).cardsOnHand.size() == 1);
        assertTrue(game.players.get(1).cardsOnHand.size() == 1);
        assertTrue(game.players.get(2).cardsOnHand.size() == 1);
        assertTrue(game.players.get(3).cardsOnHand.size() == 1);
    }

    @Before
    public void creatGame(){
        game = DependencyInjector.provideGame();
    }

    @After
    public void deleteGame() {
        game = null;
    }
}