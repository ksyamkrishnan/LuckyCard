import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest {

    List<Player> playerList;

    @Test
    public void getRankForAllA() {
        playerList.get(0).cardsOnHand.clear();
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("A"));
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("A"));
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("A"));
        assertTrue(playerList.get(0).getRank() == 14000000);
    }

    @Test
    public void getRankForAllK() {
        playerList.get(0).cardsOnHand.clear();
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("K"));
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("K"));
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("K"));
        assertTrue(playerList.get(0).getRank() == 13000000);
    }


    @Test
    public void getRankForTopEnd() {
        playerList.get(0).cardsOnHand.clear();
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("A"));
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("K"));
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("Q"));
        assertTrue(playerList.get(0).getRank() == 140000);
    }

    @Test
    public void getRankForSequence() {
        playerList.get(0).cardsOnHand.clear();
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("K"));
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("Q"));
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("J"));
        assertTrue(playerList.get(0).getRank() == 130000);
    }

    @Test
    public void getRankForNumberOrder() {
        playerList.get(0).cardsOnHand.clear();
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("4"));
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("3"));
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("2"));
        assertTrue(playerList.get(0).getRank() == 40000);
    }

    @Test
    public void getRankForNumberForPair() {
        playerList.get(0).cardsOnHand.clear();
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("4"));
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("7"));
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("7"));
        assertTrue(playerList.get(0).getRank() == 700);
    }

    @Test
    public void getRankForNumberForTopCard() {
        playerList.get(0).cardsOnHand.clear();
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("4"));
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("7"));
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("10"));
        assertTrue(playerList.get(0).getRank() == 10);
    }

    @Test
    public void getRankForNumberForTopCardWithA() {
        playerList.get(0).cardsOnHand.clear();
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("4"));
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("7"));
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("A"));
        assertTrue(playerList.get(0).getRank() == 7);
    }

    @Test
    public void getRankForLowEnd() {
        playerList.get(0).cardsOnHand.clear();
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("A"));
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("3"));
        playerList.get(0).cardsOnHand.add(DependencyInjector.provideCard("2"));
        assertTrue(playerList.get(0).getRank() == 30000);
    }

    @Before
    public void createPlayer() {
        playerList = DependencyInjector.providePlayerList();
    }

}