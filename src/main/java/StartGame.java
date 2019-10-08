public class StartGame {
    public static void main(String[] args) {
        Game game = DependencyInjector.provideGame();
        game.playGame();
    }
}
