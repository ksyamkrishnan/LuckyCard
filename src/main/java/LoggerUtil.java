import java.util.List;
import java.util.logging.Logger;

public class LoggerUtil {
    static void printPlayersInfo(List<Player> playerList) {
        for (Player player : playerList) {
            Logger.getAnonymousLogger().info(" Player " + player.name + " Rank " + player.getRank());
            for (Card card : player.cardsOnHand) {
                Logger.getAnonymousLogger().info(" " + card.faceValue);
            }
        }
    }
}
