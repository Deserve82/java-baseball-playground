import domain.Game;

public class BaseBallGame {

    public static void main(String[] ars) {
        Game game = new Game();
        int value = game.play();
        while (value != 2) {
            value = game.play();
        }
    }
}
