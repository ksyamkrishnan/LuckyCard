import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DependencyInjectorTest {

    @Test
    public void provideFullDeckCardList() {
       List<Card> cardList =  DependencyInjector.provideFullDeckCardList();
       assertTrue(cardList.size()==52);

    }

    @Test
    public void providePlayerList() {
        List<Player> playerList =  DependencyInjector.providePlayerList();
        assertTrue(playerList.size()==4);
    }

    @Test
    public void provideGame() {
        Game game =  DependencyInjector.provideGame();
        assertTrue(game.players.size()==4);
    }
}