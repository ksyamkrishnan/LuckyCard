public class LuckyCardGame {
    public static void main(String[] args) {
        Game game = DependencyInjector.provideGame();
        game.playGame();
    }
}
